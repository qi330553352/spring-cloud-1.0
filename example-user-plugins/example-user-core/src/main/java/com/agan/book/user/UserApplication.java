package com.agan.book.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.agan.book.user.persistence")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
