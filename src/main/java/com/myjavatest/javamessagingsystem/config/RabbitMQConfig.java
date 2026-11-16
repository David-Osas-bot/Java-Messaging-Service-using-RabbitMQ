package com.myjavatest.javamessagingsystem.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "user.exchange";

    public static final String QUEUE = "notification.queue";

    public static final String ROUTING_KEY = "user.notification";

    @Bean
    public DirectExchange userExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding notificationBinding(
            Queue notificationQueue,
            DirectExchange userExchange) {

        return BindingBuilder
                .bind(notificationQueue)
                .to(userExchange)
                .with(ROUTING_KEY);
    }
}
