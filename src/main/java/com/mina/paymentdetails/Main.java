package com.mina.paymentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.mina.paymentdetails", exclude = {DataSourceAutoConfiguration.class })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
