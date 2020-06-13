package com.joseph.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 全局刷新POST请求: http://127.0.0.1:11000/actuator/bus-refresh
 * 局部刷新POST请求: http://127.0.0.1:11000/actuator/bus-refresh/cloud-config-client:11002
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain11000 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain11000.class, args);
    }

}
