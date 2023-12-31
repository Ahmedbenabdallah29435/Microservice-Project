package com.example.techmasterpi.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.stripe.Stripe;


@Configuration
public class StripeConfig {

    @Value("${stripe.apiKey}")
    public String secretKey;

    @Bean
    public Stripe stripe() {
        Stripe.apiKey = secretKey;
        return new Stripe() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

}

