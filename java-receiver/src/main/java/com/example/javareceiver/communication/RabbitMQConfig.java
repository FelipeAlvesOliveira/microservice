package com.example.javareceiver.communication;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitMQConfig {

    private final static String QUEUE_NAME = "hello-queue";
    private final static String SPRING_QUEUE_NAME = "hello-spring-queue";

    @Value("${spring.rabbitmq.host}")
    private String rabbitmqHost;
    @Value("${spring.rabbitmq.port}")
    private Integer rabbitmqPort;

    @Bean
    public Queue springQueue() {
        return new Queue(SPRING_QUEUE_NAME, true);
    }

    @Bean
    public MicroserviceReceiver receiver() {
        return new MicroserviceReceiver();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void rabbitMQConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitmqHost);
        factory.setPort(rabbitmqPort);
        try {
            Connection connection = factory.newConnection();
            // create channel
            Channel channel = connection.createChannel();
            // define a channel, if the channel is not created yet, we will create
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            // action to be performed when we consume one message
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            };

            // define the consumer
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
