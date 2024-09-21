package dev.wsousa.controller;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class GenerateImageController {

    private final ImageModel imageModel;

    public GenerateImageController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }


    @GetMapping("/image")
    public ImageResponse generateImageResponse(@RequestParam String description) {
        return imageModel.call(
                new ImagePrompt(description));
    }
}

