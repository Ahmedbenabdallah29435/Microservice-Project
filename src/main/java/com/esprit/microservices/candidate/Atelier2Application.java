package com.esprit.microservices.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

public class Atelier2Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);
    }


    }

