package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService service;

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

    @GetMapping("/loadBalance")
    public Result<String> loadBalance() {
        return Result.success(serverPort);
    }

}
