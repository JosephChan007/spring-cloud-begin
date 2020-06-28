package com.joseph.cloud.service;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.entities.Order;

public interface SeataOrderService {

    Result<Boolean> create(Order order);

}
