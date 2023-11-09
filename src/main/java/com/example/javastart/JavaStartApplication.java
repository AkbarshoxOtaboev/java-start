package com.example.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStartApplication.class, args);
    }

}
