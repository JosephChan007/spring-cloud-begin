package com.joseph.cloud.service;

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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
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


}
