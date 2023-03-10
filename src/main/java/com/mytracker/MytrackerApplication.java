package com.mytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class MytrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytrackerApplication.class, args);

	}

}
