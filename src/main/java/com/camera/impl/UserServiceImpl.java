package com.camera.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.camera.entity.*;
import com.camera.mapper.UserMapper;
import com.camera.service.UserService;
import com.camera.config.MyCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
//    @Resource

    @Override
    public LoginVo login(LoginForm params) {
        LoginVo userLoginVo=userMapper.login(params.getUserCode(),params.getUserPwd());
        System.out.println(userLoginVo.getUserState());
        if(userLoginVo!=null){
            userLoginVo.setToken(UUID.randomUUID().toString());
            MyCache.put(userLoginVo.getToken(),userLoginVo,30, TimeUnit.MINUTES);
        }
//        final List<PermissionVo> permissionVoList=userMapper.selectPerm(userLoginVo.getRoleId());
//        if(permissionVoList==null || permissionVoList.size()==0){
//            throw new UnAuthorizationException("无法获取角色信息");
//        }
//        permissionVoList.forEach(item->PermissionVo.build(item,permissionVoList));
//        userLoginVo.setPerms(permissionVoList.stream().filter(item->item.getPid()==0).collect(Collectors.toList()));
        return userLoginVo;
    }

    public PageInfo<UserListForm> userList(UserListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<UserListForm> userList=userMapper.userList(params);
        return PageInfo.of(userList);
    }

    @Override
    public List<UserDetForm> userDet(Long userId) {
        List<UserDetForm> userDet=null;
        if(userId!=0){
            userDet=userMapper.userDet(userId);
        }
        return userDet;
    }

    @Override
    public void userAdd(UserDetForm params) {
        userMapper.insertUser(params);
    }

    @Override
    public void userDel(Long userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void userEdit(UserDetForm params) {
        userMapper.userEdit(params);
    }

    @Override
    public void password(LoginForm params) {
//        System.out.println("x1="+params.getPassword()+";x2="+params.getRepassword()+";y="+params.getUserId());
        if(Objects.equals(params.getPassword(), params.getRepassword())){
            userMapper.changePassword(params.getPassword(),params.getUserId());
        }
    }

    public static String method (String str){
        String pos1;
        String pos2=null;
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i); //把字符串转为字符
            if(c >= 'A' && c <= 'Z'){
                pos1=str.replace(c,(char)(c+32));
                pos2=pos1.substring(0,i)+'_'+pos1.substring(i,pos1.length());
            }
        }
        return pos2;
    }
}
