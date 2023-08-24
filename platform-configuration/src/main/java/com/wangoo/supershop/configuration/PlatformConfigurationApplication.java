package com.wangoo.supershop.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PlatformConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformConfigurationApplication.class, args);
    }

}
