package com.fh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fh.common.ServerResponse;
import org.springframework.web.client.RestTemplate;


/*@FeignClient(name = "springcloud-user",fallback = UserServiceImpl.class)*/
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    //通过id查找
    @RequestMapping(value = "queryUser")
    public ServerResponse queryById(Integer id) {
        return restTemplate.getForObject("http://springcloud-user/user/queryUser?id="+id, ServerResponse.class);
    }

    //@RequestMapping("/user/queryUser")
    //ServerResponse queryUser(@RequestParam("id") Integer id);
}
