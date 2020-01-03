package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.model.User;

public interface UserService {
    User queryUserByName(String userName);

    ServerResponse addUser(User user);

    ServerResponse sendCode(String phone);

    void updateUserMassage(User user);

    User queryUserById(Integer valueOf);

    ServerResponse queryUser(Integer id);


}
