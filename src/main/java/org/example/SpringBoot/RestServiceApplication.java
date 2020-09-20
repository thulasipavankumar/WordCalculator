package org.example.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"org.example.SpringBoot","org.example.SpringBoot.WordCalculator"})

public class RestServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestServiceApplication.class, args);
    }

}
