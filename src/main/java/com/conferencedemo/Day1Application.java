package com.conferencedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		SpringApplication.run(Day1Application.class, args);
	}

}
