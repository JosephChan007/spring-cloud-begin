package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)     // 取消数据源的自动创建，用自定义的数据源
public class CloudalibabaSeataOrderClientMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataOrderClientMain80.class, args);
    }
}
