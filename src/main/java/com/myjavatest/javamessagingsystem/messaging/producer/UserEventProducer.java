package com.myjavatest.javamessagingsystem.messaging.producer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import com.myjavatest.javamessagingsystem.messaging.event.UserEventDTO;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.myjavatest.javamessagingsystem.config.RabbitMQConfig.*;

@Service
public class UserEventProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public UserEventProducer(
            RabbitTemplate rabbitTemplate,
            ObjectMapper objectMapper) {

        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendUserEvent(UserEventDTO event) {

        try {
            String json = objectMapper.writeValueAsString(event);

            rabbitTemplate.convertAndSend(
                    EXCHANGE,
                    ROUTING_KEY,
                    json
            );

            System.out.println("Message sent: " + json);

        } catch (JacksonException e) {
            throw new RuntimeException(
                    "Failed to serialize user event", e
            );
        }
    }
}
