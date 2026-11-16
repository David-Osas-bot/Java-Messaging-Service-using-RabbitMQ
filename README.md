# Java Messaging Service with RabbitMQ

An asynchronous, event-driven messaging service built with Java and RabbitMQ. This project demonstrates reliable message publishing, routing, and consumption using AMQP protocols to decouple backend services.

## Features

- **Asynchronous Message Publishing:** Non-blocking event dispatch from producers to exchanges.
- **Reliable Queue Consumption:** Dedicated consumers with automatic/manual message acknowledgment.
- **Flexible Routing:** Configured with Direct/Topic exchanges and custom routing keys.
- **JSON Serialization:** Automatic serialization and deserialization of Java DTOs/payloads.
- **Fault Tolerance:** Error handling and Dead Letter Queue (DLQ) support for failed messages.

## Tech Stack

- **Language:** Java 17+ *(update to match your version)*
- **Framework:** Spring Boot / Jakarta EE *(update to match your setup)*
- **Message Broker:** RabbitMQ
- **Build Tool:** Maven / Gradle
- **Containerization:** Docker *(optional)*

## Architecture Overview

```text
[Producer Service] ---> [RabbitMQ Exchange] ---> [Routing Key] ---> [Queue] ---> [Consumer Service]
