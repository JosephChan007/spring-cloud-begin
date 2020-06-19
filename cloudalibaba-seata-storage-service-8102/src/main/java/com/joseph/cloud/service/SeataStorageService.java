package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

public interface SeataStorageService {

    Result<Boolean> decrease(Long productId, Integer count);

}
