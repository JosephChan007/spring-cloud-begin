package com.joseph.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)     // 取消数据源的自动创建，用自定义的数据源
public class CloudalibabaSeataStorageMain8102 {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataStorageMain8102.class, args);
    }

}
