package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NextpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextpointApplication.class, args);
	}

	// @Bean
	// public DataSource DT() {
	// DriverManagerDataSource DS = new DriverManagerDataSource();
	// DS.setDriverClassName("com.mysql.jdbc.Driver");
	// DS.setUrl("jdbc:mysql://localhost:3307/NEXTPOINT");
	// DS.setUsername("root");
	// DS.setPassword("root");
	// return DS;

	// }

}
