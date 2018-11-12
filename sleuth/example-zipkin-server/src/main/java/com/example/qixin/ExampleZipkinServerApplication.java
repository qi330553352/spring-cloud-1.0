package com.example.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ExampleZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleZipkinServerApplication.class, args);
	}
}
