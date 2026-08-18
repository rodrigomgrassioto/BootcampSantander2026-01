package com.devrodrigo._612budgetingprojfinalcomia;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatClientController {
//    private final OpenAiChatModel openAiChatModel;
    private final ChatClient chatClient; // o chatClient aceita vários servicos, como gemini, openai e outros

    public ChatClientController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat-client")
//    String chat(String prompt){
//        return this.openAiChatModel.call(prompt);
//    }
    String chat(String prompt){
        return this.chatClient.prompt()
                .system("Nunca invente nada. Se não souber, diga não sei ou algo parecido com Não tenho essa informação em meu banco de dados")
                .user(prompt).call().content();
    }
}
