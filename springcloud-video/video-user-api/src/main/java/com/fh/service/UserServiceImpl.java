package com.fh.service;

import org.springframework.stereotype.Component;
import com.fh.common.ServerResponse;


@Component
public class UserServiceImpl {




    public ServerResponse queryUser(Integer id) {        return ServerResponse.error("熔断降级");
    }
}
