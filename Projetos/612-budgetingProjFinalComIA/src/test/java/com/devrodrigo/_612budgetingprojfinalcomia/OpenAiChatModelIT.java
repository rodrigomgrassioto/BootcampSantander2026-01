package com.devrodrigo._612budgetingprojfinalcomia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
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

//    @Autowired // ativar se for usar config em application.properties
//    OpenAiChatModel chatModel; // ativar se for usar config em application.properties

    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        // essa config pode ser definida em application.properties
        var options = OpenAiChatOptions.builder()
                .model("qwen/qwen3-v1-8b")
//                .model("gpt-4o-mini")
                .baseUrl("http://192.168.100.10:1234/v1")
                .temperature(0.8) // criatividade do modelo, ser criativo
                .responseFormat(OpenAiChatModel.ResponseFormat.builder().type(OpenAiChatModel.ResponseFormat.Type.TEXT).build())
                .maxTokens(500)
                .build();
        var chatModel = OpenAiChatModel.builder()
                .options(options)
                .build();

        var response = chatModel.call("Gere um registro de budgeting, com descrição do gasto e valor em reais e local. " +
                "Retornar no formato tabela, contendo: Data | Descrição do gasto | Valor R$ | Local");
        assertThat(response).isNotEmpty();

        System.out.println(response);
    }
}
