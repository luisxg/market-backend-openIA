package com.luis.openai.chatgptspringreactive.controller;

import com.luis.openai.chatgptspringreactive.dto.MessageDto;
import com.luis.openai.chatgptspringreactive.service.GPTChatService;
import org.mvnsearch.chatgpt.spring.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class ChatController {

    @Autowired
    private ChatGPTService chatGPTService;

    @Autowired
    private GPTChatService gptChatService;

    @PostMapping("/chat")
    public Mono<MessageDto> chat(@RequestBody String prompt) {
        return gptChatService.getPrompt(prompt).map(r -> new MessageDto(r));
    }
}
