package com.example.faq_project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info = @Info(title = "FAQ API", version = "1.0", description = "FAQ API Documentation"))
@SpringBootApplication
public class FaqProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqProjectApplication.class, args);
	}

}
