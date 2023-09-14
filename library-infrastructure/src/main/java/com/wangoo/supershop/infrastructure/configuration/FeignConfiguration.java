package com.wangoo.supershop.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.wangoo.supershop")
public class FeignConfiguration {






}
