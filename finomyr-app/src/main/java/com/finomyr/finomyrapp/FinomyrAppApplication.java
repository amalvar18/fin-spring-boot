package com.finomyr.finomyrapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.finomyr.finomyrapp.model"
})
@EnableJpaRepositories(basePackages = {
        "com.finomyr.finomyrapp.user.repo",
        "com.finomyr.finomyrapp.tax.repo"
})
public class FinomyrAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinomyrAppApplication.class, args);
    }
}
