package com.mina.paymentdetails.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record PaymentDetails(Account sendingAccount,
                             Account receivingAccount,
                             String reference,
                             BigDecimal amount,
                             String currency,
                             LocalDateTime timestamp) {

}



