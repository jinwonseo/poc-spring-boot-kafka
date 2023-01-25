package kr.sprouts.sandbox.kafka.service;

import kr.sprouts.sandbox.kafka.dto.schema.TestSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class ProducerService {

    private final KafkaTemplate<String, TestSchema> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, TestSchema> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(TestSchema schema) {

        ListenableFuture<SendResult<String, TestSchema>> future =
                this.kafkaTemplate.send("spring-boot-kafka-avsc", schema);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(@NonNull Throwable ex) {
                log.error(ex.getLocalizedMessage());
            }

            @Override
            public void onSuccess(SendResult<String, TestSchema> result) {
                log.info(result.toString());
            }
        });
    }
}
