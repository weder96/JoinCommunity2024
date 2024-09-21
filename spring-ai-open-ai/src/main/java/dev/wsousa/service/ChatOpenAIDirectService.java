package dev.wsousa.service;

import java.io.IOException;

public interface ChatOpenAIDirectService {
    String chatOpenAiDirectCall(String message) throws IOException, InterruptedException;
}
