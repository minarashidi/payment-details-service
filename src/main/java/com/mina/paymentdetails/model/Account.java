package com.mina.paymentdetails.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record Account(String bankId,
                      String accountNumber,
                      String iban,
                      String accountOwner) {

}



