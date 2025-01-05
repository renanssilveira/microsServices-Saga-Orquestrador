package br.com.microservices.orchestrated.paymentservice.core.consumer;


import br.com.microservices.orchestrated.paymentservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PaymentConsumer {

    private final JsonUtil jsonUtil;


    @KafkaListener(topics = "${spring.kafka.topic.payment-success}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumePaymentSuccessEvent(String message) {
        log.info("Receiveng Event {} from Start payment-success", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }

    @KafkaListener(topics = "${spring.kafka.topic.payment-fail}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumePaymentFailEvent(String message) {
        log.info("Receiveng Event rollback {} from Start payment-fail", message);
        var event = jsonUtil.toEvent(message);
        log.info(event.toString());
    }



}
