package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Accessory;
import com.fh.param.AccessorySearchParam;
import com.fh.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("accessory/")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;
   //查询分页方法
   @RequestMapping("queryList")
   public ServerResponse queryList(AccessorySearchParam accessorySearchParam){
       Long totalCount = accessoryService.queryCount(accessorySearchParam);
       List<Accessory> list =  accessoryService.queryList(accessorySearchParam);
       Map map = new HashMap();
       map.put("draw",accessorySearchParam.getDraw());
       map.put("recordsTotal",totalCount);
       map.put("recordsFiltered",totalCount);
       map.put("data",list);
       return ServerResponse.success(map);
   }

   //按照电影id普通查询集数
    @RequestMapping("queryList2")
    public ServerResponse queryList2(Integer id){
        return accessoryService.queryList2(id);

    }
    //按照电影id普通查询集数
    @RequestMapping("queryAccessoryId")
    public ServerResponse queryAccessoryId(Integer movieId,Integer accessoryId){
        return accessoryService.queryAccessoryId(movieId,accessoryId);

    }



    //增加附件方法
   @RequestMapping("addAccessory")
    public ServerResponse addAccessory(Accessory accessory){
       return accessoryService.addAccessory(accessory);
   }
   //回显方法
   @RequestMapping("getAccessoryById")
    public ServerResponse getAccessoryById(Integer id){
       return accessoryService.getAccessoryById(id);
   }

   //修改方法
    @RequestMapping("updateAccessory")
    public ServerResponse updateAccessory(Accessory accessory){
       return accessoryService.updateAccessory(accessory);
    }
    //删除方法
    @RequestMapping("deleteAccessory")
    public ServerResponse deleteAccessory(Integer id){
       return accessoryService.deleteAccessory(id);
    }


}
