package kr.sprouts.sandbox.kafka.controller;

import kr.sprouts.sandbox.kafka.service.ProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ProduceController.REQUEST_PATH)
public class ProduceController {
    protected static final String REQUEST_PATH = "/";

    private final ProducerService producerService;

    public ProduceController(ProducerService producerService) {
        this.producerService = producerService;
    }
}
