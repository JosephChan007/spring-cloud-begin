package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
public class CloudalibabaSeataOrderClientMain80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataOrderClientMain80.class, args);
    }

}
