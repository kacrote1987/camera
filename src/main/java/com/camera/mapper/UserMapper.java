package com.camera.mapper;

import com.camera.entity.LoginVo;
import com.camera.entity.UserDetForm;
import com.camera.entity.UserListForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    LoginVo login(String userCode, String userPwd);
    List<UserListForm> userList(@Param("params") UserListForm params);
    List<UserDetForm> userDet(Long userId);
    boolean insertUser(@Param("params") UserDetForm params);
    boolean deleteUser(Long userId);
    boolean userEdit(@Param("params") UserDetForm params);
    boolean changePassword(String password,Long userId);
}
