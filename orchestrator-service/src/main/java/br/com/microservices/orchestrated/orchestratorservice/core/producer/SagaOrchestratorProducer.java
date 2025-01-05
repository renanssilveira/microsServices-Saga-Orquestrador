package br.com.microservices.orchestrated.orchestratorservice.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SagaOrchestratorProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendEvent(String topic, String payload) {
    try {
      log.info("Sending message to topic: {} with data : {}", topic, payload);
      kafkaTemplate.send(topic, payload);
    } catch (Exception e) {
      log.error("Error sending message to topic {} with data {}", topic, e.getMessage());
    }
  }
}
