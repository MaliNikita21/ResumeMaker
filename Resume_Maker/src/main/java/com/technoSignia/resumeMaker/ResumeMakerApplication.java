package com.technoSignia.resumeMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ResumeMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeMakerApplication.class, args);
	}

}
