package com.mina.paymentdetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mina.paymentdetails.model.PaymentDetails;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentDetailsDto(@JsonProperty("sending_account") AccountDto sendingAccount,
                                @JsonProperty("receiving_account") AccountDto receivingAccount,
                                @NonNull @JsonProperty("reference") String reference,
                                @JsonProperty("amount") BigDecimal amount,
                                @JsonProperty("currency") String currency) {


  public PaymentDetails toModel() {
    return new PaymentDetails(sendingAccount.fromDto(),
        receivingAccount.fromDto(),
        reference,
        amount,
        currency,
        LocalDateTime.now());
  }

  public static PaymentDetailsDto fromDomain(PaymentDetails paymentDetails) {
    return PaymentDetailsDto.builder()
        .sendingAccount(AccountDto.fromDomain(paymentDetails.sendingAccount()))
        .receivingAccount(AccountDto.fromDomain(paymentDetails.receivingAccount()))
        .reference(paymentDetails.reference())
        .amount(paymentDetails.amount())
        .currency(paymentDetails.currency())
        .build();
  }
}


