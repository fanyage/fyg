package com.fh.controller;

import com.fh.Service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer/")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;//

    @RequestMapping("queryList")
    public String queryList() {
        return consumerService.queryList();
    }

}
