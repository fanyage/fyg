package com.fh.Service;

import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String queryList() {
        return "error";
    }
}
