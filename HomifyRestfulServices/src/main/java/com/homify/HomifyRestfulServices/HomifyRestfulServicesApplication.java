package com.homify.HomifyRestfulServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class HomifyRestfulServicesApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(HomifyRestfulServicesApplication.class, args);
	}

}
