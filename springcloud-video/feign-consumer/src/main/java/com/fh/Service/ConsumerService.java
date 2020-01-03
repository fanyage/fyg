package com.fh.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-provide", fallback = ConsumerServiceImpl.class)
public interface ConsumerService {

    @RequestMapping("video/test1")
    String queryList();
}
