package com.example.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class ExampleZipkinMqServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleZipkinMqServerApplication.class, args);
	}
}
