package kr.sprouts.sandbox.kafka.service;

import kr.sprouts.sandbox.kafka.dto.TestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class ProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(TestRequest request) {

        ListenableFuture<SendResult<String, Object>> future =
                this.kafkaTemplate.send("spring-boot-kafka-dto", request);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(ex.getLocalizedMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info(result.toString());
            }
        });
    }
}
