package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Accessory;
import com.fh.model.Page;
import com.fh.param.AccessorySearchParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessoryMapper extends BaseMapper<Accessory> {

    List<Accessory> queryList(AccessorySearchParam accessorySearchParam);

    Long queryCount(AccessorySearchParam accessorySearchParam);

    void addAccessory(Accessory accessory);

    Accessory getAccessoryById(Integer id);

    void updateAccessory(Accessory accessory);

    void deleteAccessory(Integer id);

    List queryList2(Integer id);

    Accessory queryAccessoryId(Accessory accessory);
}
