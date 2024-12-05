package com.example.aquelarre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class AquelarreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquelarreApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
return new OpenAPI()
.info(new Info()
.title("Aquelarre | SENA")
.version("1.0")
.description("Java 8  | JDK 21 | Spring Boot - Gradle | VSCode")

);
	}
}
