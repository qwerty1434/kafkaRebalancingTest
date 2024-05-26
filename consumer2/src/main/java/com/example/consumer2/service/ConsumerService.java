package com.example.consumer2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerService {
    @KafkaListener(topics = "topic1", groupId = "CONSUMER-GROUP-1")
    void consumer_2(String data) {
        log.info("Consumer 2 received data {}", data);
    }
}
