package kr.sprouts.sandbox.kafka.service;

import kr.sprouts.sandbox.kafka.dto.schema.TestSchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "spring-boot-kafka-avsc")
    public void consume(ConsumerRecord<String, TestSchema> record) {
        log.info(record.value().toString());
    }
}
