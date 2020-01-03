package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.model.Accessory;
import com.fh.param.AccessorySearchParam;

import java.util.List;

public interface AccessoryService {


    Long queryCount(AccessorySearchParam accessorySearchParam);

    List<Accessory> queryList(AccessorySearchParam accessorySearchParam);

    ServerResponse addAccessory(Accessory accessory);

    ServerResponse getAccessoryById(Integer id);

    ServerResponse updateAccessory(Accessory accessory);

    ServerResponse deleteAccessory(Integer id);

    ServerResponse queryList2(Integer id);

    ServerResponse queryAccessoryId(Integer movieId,Integer accessoryId);
}
