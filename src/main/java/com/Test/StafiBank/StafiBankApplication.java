package com.Test.StafiBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StafiBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(StafiBankApplication.class, args);
	}

}
