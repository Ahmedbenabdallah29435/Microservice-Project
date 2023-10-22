package com.example.techmasterpi;


import com.example.techmasterpi.service.RentalOfferService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
public class TechmasterpiApplication {
	public static void main(String[] args) {


		SpringApplication.run(TechmasterpiApplication.class, args);



	}


}
