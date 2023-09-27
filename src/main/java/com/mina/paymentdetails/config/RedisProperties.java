package com.mina.paymentdetails.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "payment-details.redis")
public record RedisProperties(String host,
                              String port,
                              RedisMode mode) {

  public enum RedisMode {SINGLE, CLUSTER}
}
