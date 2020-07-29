package com.wmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springboot06tkMbgApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06tkMbgApplication.class, args);
    }

}
