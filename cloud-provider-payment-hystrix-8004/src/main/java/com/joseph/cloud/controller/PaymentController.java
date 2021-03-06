package com.joseph.cloud.controller;


import com.joseph.cloud.common.Result;
import com.joseph.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/ok/{id}")
    public Result<String> ok(@PathVariable("id") Integer id) {
        String msg = paymentService.payment_ok(id);
        return Result.success(msg);
    }

    @GetMapping("/timeout/{id}")
    public Result<String> timeout(@PathVariable("id") Integer id) {
        String msg = paymentService.payment_timeout(id);
        return Result.success(msg);
    }

    @GetMapping("/circuit/{id}")
    public Result<String> circuit(@PathVariable("id") Integer id) {
        String msg = paymentService.payment_circuitBreaker(id);
        return Result.success(msg);
    }

}
