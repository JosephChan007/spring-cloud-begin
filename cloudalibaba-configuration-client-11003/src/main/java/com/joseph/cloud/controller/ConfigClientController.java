package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/nacos/config/client")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.switch}")
    private String configSwitch;


    @GetMapping("/info")
    public Result<String> getCOnfigInfo() {
        String msg = String.format("**** 动态配置中心信息，info: %s, switch: %s", configInfo, configSwitch);
        return Result.success(msg);
    }

}
