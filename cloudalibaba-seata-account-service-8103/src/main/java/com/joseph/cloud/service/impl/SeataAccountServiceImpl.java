package com.joseph.cloud.service.impl;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.dao.AccountDao;
import com.joseph.cloud.service.SeataAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class SeataAccountServiceImpl implements SeataAccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Result<Boolean> decrease(Long userId, BigDecimal money) {
        int c = accountDao.update(userId, money);
        return Result.success(c > 0);
    }
}
