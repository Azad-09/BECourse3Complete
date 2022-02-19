package com.example.mongoRest.Sprint4BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Sprint4BeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint4BeApplication.class, args);
	}

}
