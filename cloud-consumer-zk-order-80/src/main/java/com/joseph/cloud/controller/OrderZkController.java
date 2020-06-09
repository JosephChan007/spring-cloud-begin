package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderZkController {

    public static final String PAYMENT_URL ="http://cloud-provider-payment";

    @Resource
    private RestTemplate template;

    @GetMapping("/zk")
    public Result<String> zl() {
        String url = PAYMENT_URL + "/payment/zk";
        log.info("*** 查询数据URL: {}", url);
        return template.getForObject(url, Result.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
