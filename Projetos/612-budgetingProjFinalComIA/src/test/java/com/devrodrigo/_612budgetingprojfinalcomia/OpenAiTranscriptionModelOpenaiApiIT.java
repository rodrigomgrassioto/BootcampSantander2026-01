package com.devrodrigo._612budgetingprojfinalcomia;

import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiTranscriptionModelOpenaiApiIT {

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

//        var prompt = new AudioTranscriptionPrompt(recording); // na v2 spring-ai-bom

        // Trocado call por transcribe retorna string na v2 spring-ai-bom não sendo mais necessário a var prompt
        // como em application.prop.. foi configurado para spring.ai.openai.audio.transcription.response-format=json
        // usei o transcribe que retorna o texto direto

//        var response = openAiTranscriptionModel.call(prompt);
        var response = openAiTranscriptionModel.transcribe(recording);
//        System.out.println("resp é: "+response);

        assertThat(response).contains(expectedKeyword);
        System.out.println(response);
    }
}