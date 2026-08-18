package com.devrodrigo._612budgetingprojfinalcomia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.ai.openai.api.OpenAiApi; // não tem mais API na V2

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiChatModelIT {
    // código antigo não usado mais na v2 do pacote
    /*@Autowired
    OpenAiApi openAiApi;
    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        var chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .build();
    }*/

    @Autowired
    OpenAiChatModel chatModel;

    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        var options = OpenAiChatOptions.builder()
                .model("gpt-4o-mini")
                .temperature(0.8) // criatividade do modelo, ser criativo
                .responseFormat(OpenAiChatModel.ResponseFormat.builder().type(OpenAiChatModel.ResponseFormat.Type.TEXT).build())
                .maxTokens(500)
                .build();
        var chatModel = OpenAiChatModel.builder()
                .options(options)
                .build();

        var response = chatModel.call("Hello, how are you?");

        System.out.println(response);
    }
}
