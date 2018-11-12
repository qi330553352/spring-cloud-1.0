package com.example.qixin;

import com.example.qixin.stream.IReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding({IReceiveService.class})
public class ExampleReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleReceiverApplication.class, args);
	}
}
