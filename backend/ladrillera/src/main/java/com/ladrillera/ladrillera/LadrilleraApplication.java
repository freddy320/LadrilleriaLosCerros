package com.ladrillera.ladrillera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LadrilleraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LadrilleraApplication.class, args);
	}

}
