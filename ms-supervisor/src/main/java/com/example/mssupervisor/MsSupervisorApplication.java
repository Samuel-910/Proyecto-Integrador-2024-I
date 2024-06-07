package com.example.mssupervisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsSupervisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSupervisorApplication.class, args);
    }

}
