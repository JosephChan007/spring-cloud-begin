package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.service.PaymengFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/consumer/payment/feign")
public class OrderFeignController {

    @Resource
    private PaymengFeignService paymengFeignService;


    @GetMapping("/get/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        return paymengFeignService.get(id);
    }

}
