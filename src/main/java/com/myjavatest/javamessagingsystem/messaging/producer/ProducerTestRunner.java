
package com.myjavatest.javamessagingsystem.messaging.producer;

import com.myjavatest.javamessagingsystem.messaging.event.UserEventDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProducerTestRunner implements CommandLineRunner {

    private final UserEventProducer producer;

    public ProducerTestRunner(UserEventProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) {

        UserEventDTO event = new UserEventDTO(
                1L,
                "osas@gmail.com",
                "USER_REGISTERED",
                LocalDateTime.now()
        );

        producer.sendUserEvent(event);
    }
}
