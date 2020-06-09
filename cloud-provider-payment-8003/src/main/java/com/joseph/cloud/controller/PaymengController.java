package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymengController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public Result<String> zk() {
        String msg = "springcloud with zookeeper: " + serverPort + ", " + UUID.randomUUID().toString();
        return Result.success(msg);
    }


}
