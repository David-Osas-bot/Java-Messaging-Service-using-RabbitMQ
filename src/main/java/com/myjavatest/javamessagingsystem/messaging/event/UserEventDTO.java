package com.myjavatest.javamessagingsystem.messaging.event;

import java.time.LocalDateTime;

public record UserEventDTO(
        Long userId,
        String email,
        String eventType,
        LocalDateTime createdAt
) {}
