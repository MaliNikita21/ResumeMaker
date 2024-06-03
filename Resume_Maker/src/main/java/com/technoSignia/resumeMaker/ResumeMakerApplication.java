package com.technoSignia.resumeMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ResumeMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeMakerApplication.class, args);
	}

}
