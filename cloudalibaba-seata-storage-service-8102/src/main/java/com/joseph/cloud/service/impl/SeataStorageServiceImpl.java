package com.joseph.cloud.service.impl;

import com.joseph.cloud.common.Result;
import com.joseph.cloud.dao.StorageDao;
import com.joseph.cloud.service.SeataStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SeataStorageServiceImpl implements SeataStorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public Result<Boolean> decrease(Long productId, Integer count) {
        int c = storageDao.update(productId, count);
        return Result.success(c > 0);
    }
}
