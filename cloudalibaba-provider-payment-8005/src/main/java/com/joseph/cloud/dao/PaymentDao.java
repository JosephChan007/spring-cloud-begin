package com.joseph.cloud.dao;

import com.joseph.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment get(@Param("id") Long id);

}
