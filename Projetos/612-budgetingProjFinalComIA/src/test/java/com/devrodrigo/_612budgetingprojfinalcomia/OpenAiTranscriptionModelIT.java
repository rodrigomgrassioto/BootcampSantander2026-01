package com.devrodrigo._612budgetingprojfinalcomia;

import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiTranscriptionModelIT {
    record WhisperResponse(String text) {
    }

    @Autowired
    OpenAiAudioTranscriptionModel openAiTranscriptionModel;

    @ParameterizedTest
    @CsvSource({
            "recording-1.m4a, 80 reais",
            "recording-2.m4a, 40 reais",
            "recording-3.m4a, 120 reais",
            "recording-4.m4a, 90 reais",
            "recording-5.m4a, 200 reais",
            "recording-6.m4a, 60 reais",
    })
    public void should_containExpectedKeywords_when_audioFilesAreProcessed(String fileName, String expectedKeyword) {
        var recording = new ClassPathResource("audio/" + fileName);

        var prompt = new AudioTranscriptionPrompt(recording); // novidade na v2

        // para usar o whisper.cpp em rede local
        var restClient = RestClient.builder()
                .baseUrl("http://192.168.100.10:8080")
                .requestFactory(
                        new JdkClientHttpRequestFactory(
                                HttpClient.newBuilder()
                                        .connectTimeout(Duration.ofSeconds(10))
                                        .build()
                        )
                )
                .build();

        /* api oficial do OpenAi
        var response = openAiTranscriptionModel.call(prompt); */

        // para usar o whisper.cpp em rede local
        var parts = new LinkedMultiValueMap<String, Object>();
        parts.add("file", recording);

        // 4. Faz POST para /inference
//        assim retonar um json com text: ...
//        var response = restClient.post()
//                .uri("/inference")
//                .contentType(MediaType.MULTIPART_FORM_DATA)
//                .body(parts)
//                .retrieve()
//                .body(String.class);

        var response = restClient.post()
                .uri("/inference")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(parts)
                .retrieve()
                .body(WhisperResponse.class);

        // var text = response.getResult().getOutput(); // novidade na v2 - somente na api oficial
        var text = response.text();
        assertThat(text).contains(expectedKeyword);
        System.out.println(text);
    }
}