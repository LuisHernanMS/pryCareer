package com.everis.prycareers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.everis.prycareers.services.CareerService"})
@SpringBootApplication
public class PrycareersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrycareersApplication.class, args);
	}

}
