package com.mina.paymentdetails.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public record KafkaProperties(String bootstrapServers,
                              boolean saslEnabled,
                              Consumer consumer) {

  public record Consumer(ConsumerProperties paymentDetails) {

  }

  public record ConsumerProperties(
      String groupId,
      String autoOffsetReset) {

  }
}
