package com.fh.mapper;

import com.fh.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User queryUserByName(String userName);

    void addUser(User user);

    User queryUserByPhone(String phone);

    void updateUserMassage(User user);

    User queryUserById(Integer userId);
}
