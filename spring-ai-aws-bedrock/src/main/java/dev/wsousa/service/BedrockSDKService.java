package dev.wsousa.service;

public interface BedrockSDKService {

    String converse(String message);

    String converseStream(String prompt);

    String invokeModel(String prompt);

    String invokeModelWithResponseStream(String prompt);
}
