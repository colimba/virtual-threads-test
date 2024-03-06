package com.andresg.clientdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@Slf4j
public class ClientDemoControllers {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private final RestClient restClient;

    public ClientDemoControllers(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8081")
                .build();
    }

    @GetMapping("client")
    public String client() {
        log.info(ANSI_BLUE + "Request Thread {} - {}", Thread.currentThread().threadId(), Thread.currentThread().getName() + ANSI_RESET);
        this.restClient.get().uri("/demo-service")
                .retrieve()
                .toBodilessEntity();
        log.info(ANSI_GREEN + "Response Thread {} - {}", Thread.currentThread().threadId(), Thread.currentThread().getName() + ANSI_RESET);
        return Thread.currentThread().toString();
    }
}
