package com.devrodrigo._612budgetingprojfinalcomia;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class TranscriptionWhisperController {

    private final RestClient restClient;

    public TranscriptionWhisperController() {
        this.restClient = RestClient.builder()
                .baseUrl("http://192.168.100.10:8080")
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
                .body(String.class);

        System.out.println("Resposta do Whisper: " + response);

        return response;
    }
}
