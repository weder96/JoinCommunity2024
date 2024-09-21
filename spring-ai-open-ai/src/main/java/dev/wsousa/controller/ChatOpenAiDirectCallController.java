package dev.wsousa.controller;

import dev.wsousa.service.ChatOpenAIDirectService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/direct")
public class ChatOpenAiDirectCallController {

    private final ChatOpenAIDirectService chatOpenAIDirectService;

    public ChatOpenAiDirectCallController(ChatOpenAIDirectService chatOpenAIDirectService) {
        this.chatOpenAIDirectService = chatOpenAIDirectService;
    }




    @SneakyThrows
    @GetMapping("/")
    public String chatOpenAiDirectCall(@RequestParam(value = "message") String message) {
        return chatOpenAIDirectService.chatOpenAiDirectCall(message);
    }



}
