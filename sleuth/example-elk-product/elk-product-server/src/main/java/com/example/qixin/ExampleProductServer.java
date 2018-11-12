package com.example.qixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.qixin.persistence")
public class ExampleProductServer {

	public static void main(String[] args) {
		SpringApplication.run(ExampleProductServer.class, args);
	}
}
