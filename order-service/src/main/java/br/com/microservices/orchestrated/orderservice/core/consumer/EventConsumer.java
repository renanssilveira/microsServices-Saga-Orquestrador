package br.com.microservices.orchestrated.orderservice.core.consumer;


import br.com.microservices.orchestrated.orderservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EventConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = "${spring.kafka.topic.notify-ending}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeNotifyEndingEvent(String message) {
        log.info("Receiveng ending notification Event {} from Notify-ending topic", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

}
