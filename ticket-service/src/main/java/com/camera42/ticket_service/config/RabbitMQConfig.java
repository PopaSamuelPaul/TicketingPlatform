package com.camera42.ticket_service.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "ticket_email_queue";
    public static final String EXCHANGE_NAME = "ticket_exchange";
    public static final String ROUTING_KEY = "ticket.routing.key";

}
