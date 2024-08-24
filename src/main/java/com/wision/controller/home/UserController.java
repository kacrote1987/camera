package com.wision.controller.home;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.UserService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(description = "人事管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginForm params){
        LoginVo userLoginVo= userService.login(params);
        return Result.success(userLoginVo);
    }

    @ApiOperation("人员信息列表")
    @PostMapping("/userlist")
    public Result userList(UserListForm params){
        PageInfo<UserListVo> userList= userService.userList(params);
        return Result.success(userList);
    }

    @ApiOperation("人员信息详细")
    @PostMapping("/userdet")
    public Result userDet(@RequestBody Long userId){
        List<UserDetVo> userDet=userService.userDet(userId);
        return Result.success(userDet);
    }
}
