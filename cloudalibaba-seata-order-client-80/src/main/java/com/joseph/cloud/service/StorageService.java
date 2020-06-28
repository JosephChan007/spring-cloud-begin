package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cloudalibaba-seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    public Result<Boolean> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
