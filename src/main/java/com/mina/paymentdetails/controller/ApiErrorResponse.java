package com.mina.paymentdetails.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiErrorResponse(int errorCode,
                               String description) {

}
