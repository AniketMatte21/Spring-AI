package com.first_project.demo.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    // initiate the ChatClient bean
    // spring will not automatically create chatClient bean instead ChatClient.Builder() is automatically created
    public ChatClient chatClient;

   public ChatController(ChatClient.Builder builder)
   {
       //Now the chatClient bean is created
       this.chatClient = builder.build();
   }

   @GetMapping("/chat")
    public ResponseEntity<String> doChat(@RequestParam String q)
    {
        String content = chatClient.prompt(q).call().content();
        return ResponseEntity.ok(content);

    }


}
