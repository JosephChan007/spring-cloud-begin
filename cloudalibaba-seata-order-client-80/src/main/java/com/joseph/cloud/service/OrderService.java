package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("cloudalibaba-seata-order-service")
public interface OrderService {

    @GetMapping("/order/create")
    Result<Boolean> create(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId,
            @RequestParam("count") Integer count,
            @RequestParam("money") BigDecimal money
    );

    @GetMapping("/order/update")
    Result<Boolean> update(@RequestParam("userId") Long userId);

}
