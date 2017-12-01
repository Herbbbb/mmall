package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.dao.UserMapper;
import com.company.pojo.User;
import com.company.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int result = userMapper.checkUsername(username);
        if(result == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        User user = userMapper.login(username,password);
        if(user == null){
            return ServerResponse.createBySuccessMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }
}
