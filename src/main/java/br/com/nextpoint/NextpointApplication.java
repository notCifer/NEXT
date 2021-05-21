package br.com.nextpoint;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class NextpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextpointApplication.class, args);

		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contas");
		EntityManager EM = EMF.createEntityManager();
		EMF.close();
	}

}
