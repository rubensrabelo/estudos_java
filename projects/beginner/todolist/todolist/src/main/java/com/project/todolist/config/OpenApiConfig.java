package com.project.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API with Java 17 and Spring Boot 3")
						.version("v1")
						.description("Task System API allows you to add, update, delete and filter tasks by status, using Spring Boot and JPA.")
						.license(
									new License()
										.name("Apache 2.0")
										.url("http://springdoc.org")
								));
	}
}
