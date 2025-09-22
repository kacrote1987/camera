package com.camera.service;

import com.github.pagehelper.PageInfo;
import com.camera.entity.*;

import java.util.List;

public interface UserService {
    LoginVo login(LoginForm params);
    PageInfo<UserList> userList(UserList params);
    List<UserDetForm> userDet(Long userId);
    void userAdd(UserDetForm params);
    void userDel(Long userId);
    void userEdit(UserDetForm params);
    void password(LoginForm params);
}
