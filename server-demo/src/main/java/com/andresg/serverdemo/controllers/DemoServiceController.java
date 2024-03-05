package com.andresg.serverdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoServiceController {

    @GetMapping("demo-service")
    public void demoService() throws InterruptedException {
        // this will simulate the time of process some information
        Thread.sleep(3000);
        log.info("Blocking thread for 3 seconds.");
    }
}
