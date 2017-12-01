package com.company.service;

import com.company.common.ServerResponse;
import com.company.pojo.User;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface UserService {

    public ServerResponse<User> login(String username, String password);
}
