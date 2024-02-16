package com.example.javareceiver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservices")
public class MicroserviceController {

    @GetMapping
    public String hello() {
        return "Str From Second Application";
    }
}
