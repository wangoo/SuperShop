package com.wangoo.supershop.registy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlatformRegistyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformRegistyApplication.class, args);
    }

}
