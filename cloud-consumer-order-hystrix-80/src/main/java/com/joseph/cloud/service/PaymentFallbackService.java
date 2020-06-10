package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import org.springframework.stereotype.Component;

/**
 * 针对 CLOUD-PAYMENT-HYSTRIX-SERVICE 服务的每一个接口的异常处理类
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public Result<String> ok(Integer id) {
        String msg = "*********** PaymentFallbackService_ok_handler....id: " + id;
        return Result.success(msg);
    }

    @Override
    public Result<String> timeout(Integer id) {
        String msg = "*********** PaymentFallbackService_timeout_handler....id: " + id;
        return Result.success(msg);
    }

}
