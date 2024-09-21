package dev.wsousa.controller;

import dev.wsousa.service.BedrockSDKTitanService;
import org.springframework.ai.bedrock.titan.BedrockTitanEmbeddingModel;
import org.springframework.ai.bedrock.titan.BedrockTitanEmbeddingOptions;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generate")
public class GenerateImageController {
    private final EmbeddingModel embeddingModel;
    private final BedrockSDKTitanService bedrockSDKTitanService;

    public GenerateImageController(EmbeddingModel embeddingModel, BedrockSDKTitanService bedrockSDKTitanService) {
        this.embeddingModel = embeddingModel;
        this.bedrockSDKTitanService = bedrockSDKTitanService;
    }

    @GetMapping("/embeddingModel")
    public EmbeddingResponse image(@RequestParam(value = "prompt") String prompt) {
        return  embeddingModel.call(
                new EmbeddingRequest(List.of(prompt),
                        BedrockTitanEmbeddingOptions.builder()
                                .withInputType(BedrockTitanEmbeddingModel.InputType.TEXT)
                                .build()));
    }

    @GetMapping("/image-titan")
    public String imageTitan(@RequestParam(value = "prompt") String prompt) {
        return  bedrockSDKTitanService.invokeModel(prompt);
    }
}
