package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvide1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvide1Application.class, args);
    }

    @Bean
    RestTemplate restTemplate (){
        return new RestTemplate();
    }

}
