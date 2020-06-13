package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain11001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain11001.class, args);
    }
}
