package br.com.microservices.orchestrated.productvalidationservice.core.consumer;

import br.com.microservices.orchestrated.productvalidationservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ProductValidationConsumer {

    private final JsonUtil jsonUtil;


    @KafkaListener(topics = "${spring.kafka.topic.product-validation-success}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeProductValidationSuccessEvent(String message) {
        log.info("Receiveng Event {} from Start product-validation-success", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

    @KafkaListener(topics = "${spring.kafka.topic.product-validation-fail}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeProductValidationEvent(String message) {
        log.info("Receiveng Event rollback {} from Start product-validation-fail", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }



}
