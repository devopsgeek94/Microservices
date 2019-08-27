package com.lifetolearn.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MylearningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylearningServiceApplication.class, args);
	}

}
