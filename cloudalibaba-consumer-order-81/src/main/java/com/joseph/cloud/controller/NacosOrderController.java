package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/consumer/payment/nacos")
public class NacosOrderController {

    public static final String PAYMENT_URL ="http://nacos-payment-service";


    @Resource
    private RestTemplate template;


    @GetMapping("/get/{id}")
    public Result<Payment> getObject(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "/payment/get/" + id;
        log.info("*** 查询数据URL: {}", url);
        return template.getForObject(url, Result.class);
    }

}
