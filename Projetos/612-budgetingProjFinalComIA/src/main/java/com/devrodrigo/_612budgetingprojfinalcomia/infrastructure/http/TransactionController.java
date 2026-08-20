package com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http;

import com.devrodrigo._612budgetingprojfinalcomia.TranscriptionWhisperController;
import com.devrodrigo._612budgetingprojfinalcomia.application.ListTransactionsByCategoryUseCase;
import com.devrodrigo._612budgetingprojfinalcomia.application.PersistTransactionUseCase;
import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;
import com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.request.TransactionRequest;
import com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.response.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.ai.audio.tts.TextToSpeechModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final PersistTransactionUseCase persistTransactionUseCase;
    private final ListTransactionsByCategoryUseCase listTransactionsByCategoryUseCase;
//    private final TranscriptionModel transcriptionModel; // não usando pois estou usando o whisper e não modelo da OPENIA
    private final ChatClient chatClient;
    private final TextToSpeechModel textToSpeechModel;
    private final TranscriptionModel transcriptionModel;


    // requisito usando whisper para converter audio em texto
    private final RestClient restClient;

    public TransactionController(
            PersistTransactionUseCase persistTransactionUseCase,
            ListTransactionsByCategoryUseCase listTransactionsByCategoryUseCase,
            @Value("classpath:prompts/system-message.st") Resource systemPrompt,
            TextToSpeechModel textToSpeechModel,
            TranscriptionModel transcriptionModel,
            ChatClient.Builder chatClientBuilder
    ) throws IOException {
        this.persistTransactionUseCase = persistTransactionUseCase;
        this.listTransactionsByCategoryUseCase = listTransactionsByCategoryUseCase;
        this.textToSpeechModel = textToSpeechModel;
        this.transcriptionModel = transcriptionModel;
        this.chatClient = chatClientBuilder
                .defaultSystem(systemPrompt.getContentAsString(Charset.defaultCharset()))
                .defaultTools(persistTransactionUseCase, listTransactionsByCategoryUseCase)
                .build();
        // usando whisper
        this.restClient = RestClient.builder()
                .baseUrl("http://192.168.100.10:8080")
                .requestFactory(
                        new JdkClientHttpRequestFactory(
                                HttpClient.newBuilder()
                                        .connectTimeout(Duration.ofSeconds(10))
                                        .build()
                        )
                )
                .build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse createTransaction(@RequestBody TransactionRequest request) {
        var transaction = persistTransactionUseCase.execute(request.toInput());
        return TransactionResponse.from(transaction);
    }

    @GetMapping("/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponse> listTransactionsByCategory(@PathVariable Category category) {
        return listTransactionsByCategoryUseCase.execute(category)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    // converter audio para string com whisper
    record WhisperResponse(String text) {
    }


    @PostMapping(value = "/ai-api-whisper-puro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "audio/mp3")
    ResponseEntity<Resource> transcribeWithWhisper(@RequestParam("file") MultipartFile file) throws IOException {
        var parts = new LinkedMultiValueMap<String, Object>();
        parts.add("file", file.getResource());

        var response = restClient.post()
                .uri("/inference")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(parts)
                .retrieve()
                .body(TransactionController.WhisperResponse.class); // converte para objeto

        var userMessage = response.text().replace("\n", "");

        var resultTextIa = chatClient.prompt().user(userMessage).call().content();
        System.out.println("A IA retornou: \n"+resultTextIa);

        // converter texto em audio
        byte[] audio = textToSpeechModel.call(resultTextIa);
        var resource = new ByteArrayResource(audio);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("audio.mp3")
                                .build()
                                .toString())
                .body(resource);
    }

    @PostMapping(value = "/ai-api-openai", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "audio/mp3")
    ResponseEntity<Resource> transcribe(@RequestParam("file") MultipartFile file) throws IOException {
        var userMessage = transcriptionModel.transcribe(file.getResource());
        var result = chatClient.prompt().user(userMessage).call().content();

        byte[] audio = textToSpeechModel.call(result);
        var resource = new ByteArrayResource(audio);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("audio.mp3")
                                .build()
                                .toString())
                .body(resource);
    }
}
