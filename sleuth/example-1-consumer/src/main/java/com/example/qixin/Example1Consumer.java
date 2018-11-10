package com.example.qixin;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Example1Consumer {

	@Bean
	public Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(Example1Consumer.class, args);
	}
}
