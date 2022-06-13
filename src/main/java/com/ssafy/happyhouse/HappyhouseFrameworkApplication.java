package com.ssafy.happyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HappyhouseFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyhouseFrameworkApplication.class, args);
	}

}
