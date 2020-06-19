package com.joseph.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    int update(@Param("productId") Long userId, @Param("money") BigDecimal money);

}
