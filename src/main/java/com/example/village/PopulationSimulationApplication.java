package com.example.village;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PopulationSimulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopulationSimulationApplication.class, args);
	}

}
