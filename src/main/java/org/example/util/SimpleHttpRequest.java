package org.example.util;

import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public class SimpleHttpRequest {

    public static void request() throws IOException {

        WebClient webClient = WebClient.create("http://localhost:8081");
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/bot/eva/code")
                        .queryParam("id", "value1")
                        .queryParam("code", "value2")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}