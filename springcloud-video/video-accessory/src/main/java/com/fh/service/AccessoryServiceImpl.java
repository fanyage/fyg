package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.mapper.AccessoryMapper;
import com.fh.model.Accessory;
import com.fh.param.AccessorySearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryMapper accessoryMapper;


    @Override
    public Long queryCount(AccessorySearchParam accessorySearchParam) {
        return accessoryMapper.queryCount(accessorySearchParam);
    }

    @Override
    public List<Accessory> queryList(AccessorySearchParam accessorySearchParam) {
        return accessoryMapper.queryList(accessorySearchParam);
    }

    @Override
    public ServerResponse addAccessory(Accessory accessory) {
        accessoryMapper.addAccessory(accessory);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse getAccessoryById(Integer id) {
        Accessory accessory = accessoryMapper.getAccessoryById(id);
        return ServerResponse.success(accessory);
    }

    @Override
    public ServerResponse updateAccessory(Accessory accessory) {
        accessoryMapper.updateAccessory(accessory);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteAccessory(Integer id) {
        accessoryMapper.deleteAccessory(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse queryList2(Integer id) {
       List list =  accessoryMapper.queryList2(id);
        return ServerResponse.success(list);
    }

    @Override
    public ServerResponse queryAccessoryId(Integer movieId,Integer accessoryId) {
        Accessory accessory = new Accessory();
        accessory.setMovieId(movieId);
        accessory.setAccessoryId(accessoryId);
       Accessory accessory1 =  accessoryMapper.queryAccessoryId(accessory);
        return ServerResponse.success(accessory1);
    }
}
