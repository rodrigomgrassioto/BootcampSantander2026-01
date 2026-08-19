package com.devrodrigo._612budgetingprojfinalcomia;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Duration;

@RestController
@RequestMapping("api")
public class TranscriptionWhisperController {
    record WhisperResponse(String text) {
    }

    private final RestClient restClient;

    public TranscriptionWhisperController() {
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

    @PostMapping(value = "/transcribe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String transcribe(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("file é: "+file);

        var parts = new LinkedMultiValueMap<String, Object>();
        parts.add("file", file.getResource());

        var response = restClient.post()
                .uri("/inference")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(parts)
                .retrieve()
                .body(WhisperResponse.class); // converte para objeto

        System.out.println("Json é: " + response);

        var text = response.text().replace("\n", "");
        System.out.println("Text é:: " + text);

        return text;
    }
}
