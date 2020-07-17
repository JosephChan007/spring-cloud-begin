package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLoadBalance myLoadBalance;


    @GetMapping("/create")
    public Result create(Payment payment) {
        String url = PAYMENT_URL + "/payment/create";
        log.info("*** 插入数据URL: {}, 数据: {}", url, payment);
        return template.postForObject(url, payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result<Payment> get(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "/payment/get/" + id;
        log.info("*** 查询数据URL: {}", url);
        return template.getForObject(url, Result.class);
    }

    @GetMapping("/loadBalance")
    public Result<String> loadBalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(CollectionUtils.isEmpty(instances)) {
            return null;
        }

        ServiceInstance instance = myLoadBalance.getServiceInstance(instances);
        URI uri = instance.getUri();
        String url = uri + "/payment/loadBalance";
        log.info("****** 服务接口地址: {}", url);

        return restTemplate.getForObject(url, Result.class);
    }

    @GetMapping("/zipkin")
    public Result zipkin() {
        String url = PAYMENT_URL + "/payment/zipkin";
        log.info("*** zipkin测试URL: {}", url);
        return template.getForObject(url, Result.class);
    }

}
