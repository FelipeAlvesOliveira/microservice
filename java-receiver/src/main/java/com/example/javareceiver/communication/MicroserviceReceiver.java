package com.example.javareceiver.communication;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello-spring-queue")
public class MicroserviceReceiver {

    @RabbitHandler
    public void listen(String in) {
        System.out.println("Message read from hello-spring-queue : " + in);
    }
}
