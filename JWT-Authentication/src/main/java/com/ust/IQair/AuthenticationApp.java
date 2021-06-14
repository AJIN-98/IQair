package com.ust.IQair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AuthenticationApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApp.class, args);
	}
}
