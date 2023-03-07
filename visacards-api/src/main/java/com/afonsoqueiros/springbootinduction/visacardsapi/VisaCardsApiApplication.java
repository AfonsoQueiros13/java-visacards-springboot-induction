package com.afonsoqueiros.springbootinduction.visacardsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"api", "repository"})
@EnableJpaRepositories("repository")

public class VisaCardsApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(VisaCardsApiApplication.class, args);
	}

}
