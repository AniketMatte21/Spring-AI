package com.springAI.OllamaAI.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


    public ChatClient chatClient;

    public ChatController(ChatClient.Builder builder)
    {
        this.chatClient = builder.build();
    }
    @GetMapping("/chat")
    public ResponseEntity<String> chatResponse(@RequestParam("q") String query)
    {
        String content = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(content);
    }
}
