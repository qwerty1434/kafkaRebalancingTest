package com.example.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produceToPartition0() {
        kafkaTemplate.send("topic1",0,"","from partition0");
        log.info("send to partition0 completed");
    }
    public void produceToPartition1() {
        kafkaTemplate.send("topic1",1,"","from partition1");
        log.info("send to partition1 completed");
    }
    public void produceToPartition2() {
        kafkaTemplate.send("topic1",2,"","from partition2");
        log.info("send to partition2 completed");
    }

}
