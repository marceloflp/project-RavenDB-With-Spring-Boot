package com.projeto.bd2.petsadoption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class PetsAdoptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsAdoptionApplication.class, args);
	}

}
