package com.joseph.cloud.controller;


import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Order;
import com.joseph.cloud.service.SeataOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/seata/order")
public class SeataOrderClientController {

    @Resource
    private SeataOrderService seataOrderService;

    @GetMapping("/create")
    public Result<Boolean> create(Order order) {
        return seataOrderService.create(order);
    }

}
