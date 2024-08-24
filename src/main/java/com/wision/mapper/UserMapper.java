package com.wision.mapper;

import com.wision.entity.LoginVo;
import com.wision.entity.UserDetVo;
import com.wision.entity.UserListForm;
import com.wision.entity.UserListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    LoginVo login(String userCode, String userPwd);
    List<UserListVo> userList(String type, @Param("params") UserListForm params);
    List<UserDetVo> selDet(Long userId);
}
