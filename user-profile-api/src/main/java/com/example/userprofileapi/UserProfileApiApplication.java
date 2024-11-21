package com.example.userprofileapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.userprofileapi", "com.example.controller", "com.example.exception"})
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.model")
public class UserProfileApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserProfileApiApplication.class, args);
	}
}