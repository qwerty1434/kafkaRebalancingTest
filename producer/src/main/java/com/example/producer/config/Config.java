package com.example.producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }

//    @Autowired
//    private KafkaAdmin kafkaAdmin;
//
//    private NewTopic defaultTopic() {
//        return TopicBuilder.name("topic1")
//                .partitions(3)
//                .replicas(1)
//                .build();
//    }
//
//    @PostConstruct
//    public void init() {
//        kafkaAdmin.createOrModifyTopics(defaultTopic());
//    }


}
