package com.joseph.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloudalibaba-sentinel-service")
public interface SentinelMonitorService {

    @GetMapping("/monitor/config/save")
    public String save();

}
