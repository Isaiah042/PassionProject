package com.passion.Car_Project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.passion.Car_Project.model.Part;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarProjectApplication.class, args);

	}
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}

