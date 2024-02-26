package com.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "com.apps.todoapp.entity")
//@EnableJpaRepositories()
public class GlobalRunSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(GlobalRunSpringBoot.class,args);
    }

}
