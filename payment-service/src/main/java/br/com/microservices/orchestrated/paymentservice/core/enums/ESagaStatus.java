package br.com.microservices.orchestrated.paymentservice.core.enums;

public enum ESagaStatus {
  SUCCESS,
  ROLLEDBACK_PENDING,
  FAIL;
}
