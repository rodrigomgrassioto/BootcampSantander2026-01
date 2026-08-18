package com.devrodrigo._612budgetingprojfinalcomia;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

public class WhisperIT {

    @Test
    void should_transcribe_audio() {

        var recording = new ClassPathResource("audio/recording-1.m4a");

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

        var parts = new LinkedMultiValueMap<String, Object>();
        parts.add("file", recording);

        var response = restClient.post()
                .uri("/inference")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(parts)
                .retrieve()
                .body(String.class);

        System.out.println(response);
    }
}