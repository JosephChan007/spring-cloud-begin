package com.joseph.cloud.controller;


import com.joseph.cloud.service.SentinelMonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/monitor")
public class SentinelMonitorController {

    @Resource
    private SentinelMonitorService sentinelMonitorService;

    @GetMapping("/config/save")
    public String save() {
        return sentinelMonitorService.save();
    }

}
