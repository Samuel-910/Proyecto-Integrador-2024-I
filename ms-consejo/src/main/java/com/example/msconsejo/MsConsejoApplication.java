package com.example.msconsejo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsConsejoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsConsejoApplication.class, args);
    }

}
