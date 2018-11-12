package com.agan.book.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableBinding({ISendService.class})
public class StreamSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamSenderApplication.class, args);
	}
}
