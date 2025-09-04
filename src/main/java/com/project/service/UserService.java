package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.entity.*;

import java.util.List;

public interface UserService {
    LoginVo login(LoginForm params);
    PageInfo<UserListForm> userList(UserListForm params);
    List<UserDetForm> userDet(Long userId);
    void userAdd(UserDetForm params);
    void userDel(Long userId);
    void userEdit(UserDetForm params);
    void password(LoginForm params);
}
