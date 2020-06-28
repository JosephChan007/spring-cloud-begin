package com.joseph.cloud.service.impl;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Order;
import com.joseph.cloud.service.AccountService;
import com.joseph.cloud.service.OrderService;
import com.joseph.cloud.service.SeataOrderService;
import com.joseph.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class SeataOrderServiceImpl implements SeataOrderService {

    @Resource
    private OrderService orderService;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    public Result<Boolean> create(Order order) {

        log.info("======= 开始订单创建...");
        orderService.create(order.getUserId(), order.getProductId(), order.getCount(), order.getMoney());
        log.info("======= 完成订单创建...");

        log.info("======= 开始减商品库存...");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("======= 完成减商品库存...");

        log.info("======= 开始从用户账户扣款...");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("======= 完成从用户账户扣款...");

        log.info("======= 开始修改订单状态...");
        orderService.update(order.getUserId());
        log.info("======= 完成修改订单状态...");

        return Result.success(Boolean.TRUE);

    }

}
