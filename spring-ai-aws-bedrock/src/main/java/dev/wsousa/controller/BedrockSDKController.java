package dev.wsousa.controller;

import dev.wsousa.service.BedrockSDKService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bedrock/sdk")
public class BedrockSDKController {

    private final BedrockSDKService bedrockSDKService;

    public BedrockSDKController(BedrockSDKService bedrockSDKService) {
        this.bedrockSDKService = bedrockSDKService;
    }

    /*https://docs.aws.amazon.com/pt_br/sdk-for-java/latest/developer-guide/java_bedrock-runtime_code_examples.html*/

    @GetMapping("/chat")
    public String converse(@RequestParam(value = "prompt") String prompt) {
        return bedrockSDKService.converse(prompt);
    }

    @GetMapping("/chat/stream")
    public String converseStream(@RequestParam(value = "prompt") String prompt) {
        return bedrockSDKService.converseStream(prompt);
    }

    @GetMapping("/chat/invokeModel")
    public String invokeModel(@RequestParam(value = "prompt") String prompt) {
        return bedrockSDKService.invokeModel(prompt);
    }

    @GetMapping("/chat/invokeModelWithResponseStream")
    public String invokeModelWithResponseStream(@RequestParam(value = "prompt") String prompt) {
        return bedrockSDKService.invokeModelWithResponseStream(prompt);
    }



}
