package com.example.javasender.service;

import com.example.javasender.communication.MicroserviceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceService {

    @Autowired
    MicroserviceSender microserviceSender;

    @Value("${receiver.host}")
    private String receiverHost;
    @Value("${receiver.port}")
    private Integer receiverPort;

    public String getName() {
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://"
                +receiverHost+":"+receiverPort+"/microservices", String.class);
        return response.getBody();
    }

    public void sendMessage() {
        microserviceSender.send("some message from producer");
    }

    public void sendMessageBySpringTemplate() {
        microserviceSender.sendUsingSpringTemplate("message from spring template");
    }
}
