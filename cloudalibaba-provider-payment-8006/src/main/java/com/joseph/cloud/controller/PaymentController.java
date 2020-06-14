package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService service;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public Result<String> create(@RequestBody Payment payment) {
        log.info("*** 插入数据: {}", payment);
        int result = service.create(payment);
        log.info("*** 插入结果: {}, 数据: {}", result);
        return result > 0 ? Result.success("成功:" + serverPort) : Result.failed();
    }

    @GetMapping("/get/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        Payment p = service.get(id);
        log.info("*** 查询结果: {}", p);
        return null != p ? Result.response(Result.CODE_OK, Result.MSG_OK + ": " + serverPort, p) : Result.failed();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> log.info("^^^^ Service Application: {}", s));

        services.stream().forEach(s -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            instances.forEach(ins -> log.info("^^^^ Service Instance[{}]: {} {} {} {}", ins.getServiceId(), ins.getHost(), ins.getPort(), ins.getUri(), ins.getInstanceId()));
        });

        return this.discoveryClient;
    }

    @GetMapping("/loadBalance")
    public Result<String> loadBalance() {
        return Result.success(serverPort);
    }

    @GetMapping("/zipkin")
    public Result<String> zipkin() {
        String msg = "hi, i am payment zipkin server fallback, welcome to joseph world, haha...";
        return Result.success(msg);
    }

}
