package com.fh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("video/")
public class VideoController {
    @Value("{server.port}")
    private String prot;

    @Autowired
    private RestTemplate restTemplate;//

    @RequestMapping("text1")
    public String text1(){
       // return restTemplate.getForObject("http://localhost:8080/car/queryMapCarList.do",String.class);
        return "name:"+prot;
    }

}
