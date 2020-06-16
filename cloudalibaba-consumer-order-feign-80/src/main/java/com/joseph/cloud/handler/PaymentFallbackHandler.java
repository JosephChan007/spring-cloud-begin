package com.joseph.cloud.handler;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.service.PaymengFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHandler implements PaymengFeignService {

    @Override
    public Result<Payment> get(Long id) {
        return Result.response(Result.CODE_ERROR, "====获取Payment数据异常, id: " + id, null);
    }

}
