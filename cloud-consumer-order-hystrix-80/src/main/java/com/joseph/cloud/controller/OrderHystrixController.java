package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fall_handler")
@RequestMapping("/consumer/payment/hystrix")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public Result<String> ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.ok(id);
    }


    @GetMapping("/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
//    @HystrixCommand   // 此处走全局异常处理
    public Result<String> timeout(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        return paymentHystrixService.timeout(id);
    }

    public Result<String> timeout_handler(Integer id) {
        String msg = "消费端80，线程池: " + Thread.currentThread().getName() + " timeout handler, id: " + id + ", 请求处理繁忙...";
        return Result.success(msg);
    }

    /**
     * 全局Fallback处理
     */
    public Result<String> global_fall_handler() {
        String msg = "Global异常处理，请稍后重试...";
        return Result.success(msg);
    }


}
