package com.example.atelier2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Atelier2Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);
    }

}
