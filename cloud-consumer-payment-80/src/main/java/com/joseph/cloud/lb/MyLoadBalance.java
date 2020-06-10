package com.joseph.cloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getAndIncrement() {
        int current, next;
        do {
            current = atomicInteger.get();
            next = (current >= Integer.MAX_VALUE) ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        log.info("********第几次访问，次数: {}", next);
        return next;
    }

    public ServiceInstance getServiceInstance(List<ServiceInstance> list) {
        int index = getAndIncrement() % list.size();
        return list.get(index);
    }

}
