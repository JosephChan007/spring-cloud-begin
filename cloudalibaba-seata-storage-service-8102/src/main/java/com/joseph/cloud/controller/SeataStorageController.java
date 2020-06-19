package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.service.SeataStorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class SeataStorageController {

    @Resource
    private SeataStorageService seataStorageService;

    @PostMapping("/decrease")
    public Result<Boolean> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        return seataStorageService.decrease(productId, count);
    }

}
