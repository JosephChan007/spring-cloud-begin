package com.joseph.cloud.dao;

import com.joseph.cloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    void create(Order order);

    int update(@Param("userId") Long userId, @Param("status") Integer status);


}
