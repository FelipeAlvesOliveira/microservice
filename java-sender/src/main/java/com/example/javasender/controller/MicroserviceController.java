package com.example.javasender.controller;

import com.example.javasender.service.MicroserviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservices")
public class MicroserviceController {

    @Autowired
    MicroserviceService microserviceService;

    @GetMapping("sync")
    public String sendSyncCommunication() {
        String name = microserviceService.getName();
        return "Sync communication sent: result: '" + name + "'!";
    }

    @GetMapping("async")
    public String sendAsyncCommunication() {
        microserviceService.sendMessage();
        return "Async communication sent!";
    }

    @GetMapping("async-spring")
    public String sendAsyncCommunicationWithSpring() {
        microserviceService.sendMessageBySpringTemplate();
        return "Async communication sent with spring!";
    }

    @GetMapping("/{id}")
    public String helloId(@PathVariable Long id) {
        return "Hello id " + id + "!";
    }

    @GetMapping("/query")
    public String helloQueryParam(@RequestParam String name) {
        return "Hello query " + name + "!";
    }

    @GetMapping("/path/{name}")
    public String helloPathParam(@PathVariable String name) {
        return "Hello path " + name + "!";
    }
}
