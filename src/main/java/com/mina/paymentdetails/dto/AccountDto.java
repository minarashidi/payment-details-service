package com.mina.paymentdetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mina.paymentdetails.model.Account;
import com.mina.paymentdetails.model.PaymentDetails;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record AccountDto(@JsonProperty("bank_id") String bankId,
                         @JsonProperty("account_number") String accountNumber,
                         @JsonProperty("iban") String iban,
                         @JsonProperty("account_owner") String accountOwner) {

  public Account fromDto() {
    return new Account(bankId, accountNumber, iban, accountOwner);
  }

  public static AccountDto fromDomain(Account account) {
    return AccountDto.builder()
        .bankId(account.bankId())
        .accountNumber(account.accountNumber())
        .iban(account.iban())
        .accountOwner(account.accountOwner())
        .build();
  }
}
