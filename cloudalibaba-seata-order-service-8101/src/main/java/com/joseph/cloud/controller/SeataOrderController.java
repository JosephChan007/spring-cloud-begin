package com.joseph.cloud.controller;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Order;
import com.joseph.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class SeataOrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public Result<Boolean> create(@RequestParam("userId") Long userId,
                                  @RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count,
                                  @RequestParam("money") BigDecimal money) {
        Order order = new Order(null, userId, productId, count, money, 0);
        return orderService.create(order);
    }


    @GetMapping("/update")
    public Result<Boolean> update(@RequestParam("userId") Long userId) {
        return orderService.update(userId);
    }


}
