package com.springboot.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot")

public class WebapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapplicationApplication.class, args);

	}

}
