package com.camera.entity;

import io.swagger.annotations.ApiModel;
@ApiModel("登陆")
public class LoginForm {
//    @NotNull(message = "账号不能为空")
    private String userCode;
//    @NotNull(message = "密码不能为空")
    private String userPwd;
    private Long userId;
    private String password;
    private String repassword;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
