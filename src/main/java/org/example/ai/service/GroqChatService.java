package org.example.ai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GroqChatService {
    private final ChatModel chatModel;

    public String chat(String userPrompt){
        List<Message> messages = new ArrayList<>();

        messages.add(new UserMessage(userPrompt));

        Prompt prompt = Prompt.builder().messages(messages).build();
        ChatResponse response = chatModel.call(prompt);

        return Objects.requireNonNull(response.getResult()).getOutput().getText();
    }

}
