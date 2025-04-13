package com.springboot.aop;

import com.springboot.aop.business.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot")
public class WebapplicationApplication implements CommandLineRunner {
    BusinessService businessService;
    private Logger logger = LoggerFactory.getLogger((getClass()));

    WebapplicationApplication(BusinessService businessService) {
        this.businessService = businessService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebapplicationApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Value Returned {}", businessService.calculateMax());
    }

}
