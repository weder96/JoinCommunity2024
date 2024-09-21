package dev.wsousa.service.impl;

import dev.wsousa.service.ChatOpenAIDirectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ChatOpenAIDirectServiceImp implements ChatOpenAIDirectService {

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Override
    public String chatOpenAiDirectCall(String message) throws IOException, InterruptedException {
        var body = """
                    {
                    "model": "gpt-4",
                    "messages": [
                    {
                    "role": "assistant",
                    "content": "What is Spring Boot?"
                    }
                    ]
                    }""";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return  response.body();
    }
}
