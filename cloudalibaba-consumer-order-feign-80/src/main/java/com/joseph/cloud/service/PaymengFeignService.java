package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.handler.PaymentFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloudalibaba-payment-service", fallback = PaymentFallbackHandler.class)
public interface PaymengFeignService {

    @GetMapping("/payment/get/{id}")
    public Result<Payment> get(@PathVariable("id") Long id);

}
