package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NextpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextpointApplication.class, args);
	}

}
