package com.joseph.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.joseph.cloud.common.Result;
import com.joseph.cloud.handler.GlobalBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handle")
public class SentinelHandlerController {

    @GetMapping("/source/{id}")
    @SentinelResource(value = "source", blockHandler = "sourceHandler")
    public Result<String> source(@PathVariable("id") Long id) {
        return Result.success("====== source success...id: " + id);
    }

    public Result<String> sourceHandler(Long id, BlockException e) {
        return Result.success("====== source handler...id: " + id);
    }

    @GetMapping("/global/{id}")
    @SentinelResource(value = "global", blockHandlerClass = GlobalBlockHandler.class, blockHandler = "handleException1")
    public Result<String> global(@PathVariable("id") Long id) {
        return Result.success("====== global success...id: " + id);
    }


}
