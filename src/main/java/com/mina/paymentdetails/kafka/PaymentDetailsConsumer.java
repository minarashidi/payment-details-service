package com.mina.paymentdetails.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mina.paymentdetails.dto.PaymentDetailsDto;
import com.mina.paymentdetails.service.PaymentDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class PaymentDetailsConsumer {

  private final ObjectMapper objectMapper;
  private final PaymentDetailsService paymentDetailsService;

  @KafkaListener(
      containerFactory = "paymentDetailsKafkaListenerContainerFactory",
      topics = "payment-details",
      concurrency = "${kafka.consumer.payment-details.threads}",
      clientIdPrefix = "payment-details-service-${random.uuid}",
      autoStartup = "${kafka.consumer.payment-details.autostart}"
  )
  public void onMessage(@Payload String payload, Acknowledgment acknowledgment) {
    acknowledgment.acknowledge();

    try {
      var paymentMessageDto = objectMapper.readValue(payload, PaymentDetailsDto.class);
      log.debug("payment details message received: {}", paymentMessageDto);

      var paymentDetails = paymentMessageDto.toModel();
      paymentDetailsService.store(paymentDetails);
    } catch (Exception e) {
      log.warn("Unable to process processing account settings " + payload, e);
    }
  }
}
