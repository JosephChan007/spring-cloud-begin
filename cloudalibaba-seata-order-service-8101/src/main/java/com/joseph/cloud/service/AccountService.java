package com.joseph.cloud.service;


import com.joseph.cloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


@FeignClient("cloudalibaba-seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    Result<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
