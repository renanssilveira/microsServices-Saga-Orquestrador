package br.com.microservices.orchestrated.inventoryservice.core.consumer;


import br.com.microservices.orchestrated.inventoryservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class InventoryConsumer {

    private final JsonUtil jsonUtil;


    @KafkaListener(topics = "${spring.kafka.topic.inventory-success}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeInventorySuccessEvent(String message) {
        log.info("Receiveng Event {} from Start inventory-success", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

    @KafkaListener(topics = "${spring.kafka.topic.inventory-fail}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeInventoryFailEvent(String message) {
        log.info("Receiveng Event rollback {} from Start inventory-fail", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }



}
