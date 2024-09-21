package dev.wsousa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olympics")
public class OlympicsController {

    private static final Logger log = LoggerFactory.getLogger(OlympicsController.class);
    private final ChatClient chatClient;

    public OlympicsController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/test")
    public String getTest(@RequestParam String message) {
     return  "test";
    }

    @GetMapping("/year/2024")
    public String get2024OlympicSports(@RequestParam String message) {
        String sports = "test";// docsToStuffResource.getContentAsString(Charset.defaultCharset());
        log.info("Sports: {}", sports);
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
