package com.sesame.librairie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrairieApplication {

	public static void main(String[] args) {
		// Seule ligne qui démarre l'application : Spring crée ensuite
		// lui-même le contrôleur, le service et le repository.
		SpringApplication.run(LibrairieApplication.class, args);
	}

}
