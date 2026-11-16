
package com.myjavatest.javamessagingsystem.messaging.consumer;

import tools.jackson.core.JacksonException;
import com.myjavatest.javamessagingsystem.messaging.event.UserEventDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import static com.myjavatest.javamessagingsystem.config.RabbitMQConfig.QUEUE;

@Component
public class UserEventConsumer {

    private final ObjectMapper objectMapper;

    public UserEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = QUEUE)
    public void receiveMessage(String message) {

        try {
            UserEventDTO event = objectMapper.readValue(
                    message,
                    UserEventDTO.class
            );

            System.out.println("Message received!");
            System.out.println("User ID: " + event.userId());
            System.out.println("Email: " + event.email());
            System.out.println("Event: " + event.eventType());

        } catch (JacksonException e) {
            throw new RuntimeException(
                    "Failed to deserialize user event", e
            );
        }
    }
}
