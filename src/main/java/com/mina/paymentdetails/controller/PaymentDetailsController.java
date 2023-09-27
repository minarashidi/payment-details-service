package com.mina.paymentdetails.controller;

import com.mina.paymentdetails.dto.PaymentDetailsDto;
import com.mina.paymentdetails.model.PaymentDetails;
import com.mina.paymentdetails.service.PaymentDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentDetailsController {

  private final PaymentDetailsService paymentDetailsService;

  public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
    this.paymentDetailsService = paymentDetailsService;
  }

  @GetMapping("/v1/payment-details/{reference}")
  public ResponseEntity<PaymentDetailsDto> getPaymentDetails(@PathVariable("reference") String reference) {
    log.debug("Received GET request: {}", reference);

    PaymentDetails paymentDetails = paymentDetailsService.get(reference);
    log.info("payment details {}", paymentDetails);
    var paymentDetailsDto = PaymentDetailsDto.fromDomain(paymentDetails);
    return ResponseEntity.ok().body(paymentDetailsDto);
  }
}
