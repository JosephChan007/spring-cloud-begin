package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface SeataAccountService {

    Result<Boolean> decrease(Long userId, BigDecimal money);

}
