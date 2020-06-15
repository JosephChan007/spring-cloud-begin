package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMonitorMain9100 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMonitorMain9100.class, args);
    }

}
