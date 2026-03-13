package com.camera42.ticket_service.service;

import com.camera42.ticket_service.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(String message){
        System.out.println("========================================");
        System.out.println("📩 RABBITMQ A PRIMIT UN MESAJ NOU:");
        System.out.println(message);
        System.out.println("📧 Aici am simula trimiterea email-ului în fundal...");
        System.out.println("========================================");
    }
}
