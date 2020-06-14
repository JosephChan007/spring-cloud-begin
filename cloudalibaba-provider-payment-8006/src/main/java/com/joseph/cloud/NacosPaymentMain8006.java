package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain8006.class, args);

    }
}
