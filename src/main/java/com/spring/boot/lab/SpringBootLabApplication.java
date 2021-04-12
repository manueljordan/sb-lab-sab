package com.spring.boot.lab;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 *
 * @author manueljordan
 *
 */
@SpringBootApplication
public class SpringBootLabApplication {

	Logger logger = LoggerFactory.getLogger(SpringBootLabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabApplication.class, args);
	}

	@Bean
	@Order(1)
	CommandLineRunner inicio() {
		return (args) -> { logger.info("Spring Boot Lab Web App Iniciado!");};
	}

	@Bean
	@Order(2)
	CommandLineRunner perfiles(ConfigurableApplicationContext context) {
		return (args) -> {
			logger.info("Perfiles");
			Stream.of(context.getEnvironment()
							 .getActiveProfiles())
						     .forEach(t -> logger.info(" {}", t));
		};
	}

}
