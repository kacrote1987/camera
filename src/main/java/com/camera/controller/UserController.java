package com.camera.controller;

import com.github.pagehelper.PageInfo;
import com.camera.entity.*;
import com.camera.service.UserService;
import com.camera.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(description = "用户管理")
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

    @ApiOperation("用户信息列表")
    @PostMapping("/userList")
    public Result userList(UserListForm params){
        PageInfo<UserListForm> userList= userService.userList(params);
        return Result.success(userList);
    }

    @ApiOperation("用户详细信息")
    @PostMapping("/userDet")
    public Result userDet(@RequestBody Long userId){
        List<UserDetForm> userDet=userService.userDet(userId);
        return Result.success(userDet);
    }

    @ApiOperation("用户新增")
    @PostMapping("/userAdd")
    public Result userAdd(@RequestBody UserDetForm params){
        userService.userAdd(params);
        return Result.success();
    }

    @ApiOperation("用户删除")
    @PostMapping("/userDel")
    public Result userDel(@RequestBody Long userId){
        userService.userDel(userId);
        return Result.success();
    }

    @ApiOperation("用户修改")
    @PostMapping("/userEdit")
    public Result userEdit(@RequestBody UserDetForm params){
        userService.userEdit(params);
        return Result.success();
    }

    @ApiOperation("密码修改")
    @PostMapping("/password")
    public Result password(@RequestBody LoginForm params){
        userService.password(params);
        return Result.success();
    }
}
