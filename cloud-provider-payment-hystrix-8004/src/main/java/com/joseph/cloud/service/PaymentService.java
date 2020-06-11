package com.joseph.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String payment_ok(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " payment ok, id: " + id + ", 哈哈哈...";
    }

    @HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")     // 启动降级的时间阈值
    })
    public String payment_timeout(Integer id) {
        long timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() + " payment timeout, id: " + id + ", 完蛋了...";
    }

    public String payment_timeout_handler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " payment timeout handler, id: " + id + ", 补救了...";
    }

    @HystrixCommand(fallbackMethod = "payment_circuitBreaker_handler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                       // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")        // 失败率阈值
    })
    public String payment_circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return "线程池: " + Thread.currentThread().getName() + " payment_circuitBreaker, 流水号: " + serialNumber + ", 调用成功...";
    }

    public String payment_circuitBreaker_handler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " payment_circuitBreaker_handler, id 不能为负数，请稍后再试...";
    }


}
