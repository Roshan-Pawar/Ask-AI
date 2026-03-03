package org.example.ai.controller;

import lombok.RequiredArgsConstructor;
import org.example.ai.model.ChatResponse;
import org.example.ai.service.GroqChatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final GroqChatService chatService;

    @GetMapping("/")
    public String index(Model model){
        return "chat";
    }

    @PostMapping(value = "/api/chat",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseBody
    public ChatResponse chat(@RequestBody PromptDto request) {
        String answer = chatService.chat(request.getPrompt());
        return new ChatResponse("assistant", answer);
    }

    //DTO for incoming request
    public static record PromptDto(String prompt){
        public String getPrompt() {
            return prompt;
        }
    }

}
