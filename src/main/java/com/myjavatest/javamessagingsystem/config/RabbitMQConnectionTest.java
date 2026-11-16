
package com.myjavatest.javamessagingsystem.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConnectionTest {

    @Bean
    CommandLineRunner testRabbitConnection(
            RabbitTemplate rabbitTemplate) {

        return args -> {

            rabbitTemplate.execute(channel -> {

                System.out.println(
                        "Successfully connected to RabbitMQ!"
                );

                return null;
            });

        };
    }
}
