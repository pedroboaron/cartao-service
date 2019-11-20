package com.pedro.cartoesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient        // Enable eureka client.
public class CartoesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartoesServiceApplication.class, args);
    }

}
