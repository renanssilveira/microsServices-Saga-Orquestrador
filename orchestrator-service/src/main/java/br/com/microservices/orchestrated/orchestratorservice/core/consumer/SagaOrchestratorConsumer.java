package br.com.microservices.orchestrated.orchestratorservice.core.consumer;



import br.com.microservices.orchestrated.orchestratorservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SagaOrchestratorConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = "${spring.kafka.topic.start-saga}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeStartSagaEvent(String message) {
        log.info("Receiveng Event {} from Start Saga topic", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }


    @KafkaListener(topics = "${spring.kafka.topic.orchestrator}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrchestratorEvent(String message) {
        log.info("Receiveng Event {} from Start orchestrator", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

    @KafkaListener(topics = "${spring.kafka.topic.finish-success}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeFinishSuccessEvent(String message) {
        log.info("Receiveng Event {} from Start finish-success", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

    @KafkaListener(topics = "${spring.kafka.topic.finish-fail}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeFinishFailEvent(String message) {
        log.info("Receiveng Event {} from Start finish-fail", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }



}
