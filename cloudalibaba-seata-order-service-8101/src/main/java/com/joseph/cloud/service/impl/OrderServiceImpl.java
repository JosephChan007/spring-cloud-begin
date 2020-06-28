package com.joseph.cloud.service.impl;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.dao.OrderDao;
import com.joseph.cloud.entities.Order;
import com.joseph.cloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public Result<Boolean> create(Order order) {
        orderDao.create(order);
        return Result.success(Boolean.TRUE);
    }

    @Override
    public Result<Boolean> update(Long userId) {
        orderDao.update(userId, 0);
        return Result.success(Boolean.TRUE);
    }


}
