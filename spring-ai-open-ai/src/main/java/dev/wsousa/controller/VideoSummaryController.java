package dev.wsousa.controller;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/video")
@Slf4j
public class VideoSummaryController {

    private static final Logger log = LoggerFactory.getLogger(VideoSummaryController.class);

    @PostMapping("/summarize")
    public ResponseEntity<String> summarizeVideo(@RequestBody String videoUrl) {
        log.info("url: "+videoUrl);
        String transcription = transcribeVideo(videoUrl);
        String summary = getSummaryFromOpenAI(transcription);
        return ResponseEntity.ok(summary);
    }

    private String transcribeVideo(String url) {
        // Lógica para transcrever o vídeo
        return  "transcrypter Video";
    }

    private String getSummaryFromOpenAI(String text) {
        // Lógica para enviar a transcrição para a API OpenAI
        // e retornar o resumo
        return  "Resume Video";
    }
}