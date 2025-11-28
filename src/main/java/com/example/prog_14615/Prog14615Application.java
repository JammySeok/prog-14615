package com.example.prog_14615;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Prog14615Application {

	public static void main(String[] args) {
		SpringApplication.run(Prog14615Application.class, args);
	}

}
