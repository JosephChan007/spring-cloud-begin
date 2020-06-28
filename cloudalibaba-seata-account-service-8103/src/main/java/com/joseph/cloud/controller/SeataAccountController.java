package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.service.SeataAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/account")
public class SeataAccountController {

    @Resource
    private SeataAccountService storageService;

    @PostMapping("/decrease")
    public Result<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return storageService.decrease(userId, money);
    }

}
