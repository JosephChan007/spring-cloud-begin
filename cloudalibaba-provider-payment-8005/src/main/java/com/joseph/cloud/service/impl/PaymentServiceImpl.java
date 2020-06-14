package com.joseph.cloud.service.impl;

import com.joseph.cloud.dao.PaymentDao;
import com.joseph.cloud.entities.Payment;
import com.joseph.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao dao;

    @Override
    public int create(Payment payment) {
        return dao.create(payment);
    }

    @Override
    public Payment get(Long id) {
        return dao.get(id);
    }

}
