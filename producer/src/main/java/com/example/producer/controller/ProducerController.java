package com.example.producer.controller;


import com.example.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping
    public void sendAll() {
        log.info("[sendAll] start");
        producerService.produceToPartition0();
        producerService.produceToPartition1();
        producerService.produceToPartition2();
        log.info("[sendAll] end");

    }

    @GetMapping("/0")
    public void send0() {
        log.info("[send0] start");
        producerService.produceToPartition0();
        log.info("[send0] start");
    }

    @GetMapping("/1")
    public void send1() {
        log.info("[send1] start");
        producerService.produceToPartition1();
        log.info("[send1] end");
    }

    @GetMapping("/2")
    public void send2() {
        log.info("[send2] start");
        producerService.produceToPartition2();
        log.info("[send2] end");
    }

}
