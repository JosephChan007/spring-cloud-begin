package com.joseph.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.joseph.cloud.common.Result;

/**
 * 单独的各种Sentinel异常处理类
 * 注意：每个方法都必须是static
 */
public class GlobalBlockHandler {

    public static Result<String> handleException1(BlockException e) {
        return Result.success("===== global handle exception1 ...");
    }

    public static Result<String> handleException2(BlockException e) {
        return Result.success("===== global handle exception2 ...");
    }


}
