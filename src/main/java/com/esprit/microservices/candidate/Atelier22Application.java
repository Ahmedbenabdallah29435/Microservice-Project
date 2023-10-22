package com.esprit.microservices.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

public class Atelier22Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier22Application.class, args);
    }


    }

