package com.jin.bean;

/**
 * @author jinpeng
 * @date 2019/3/13.
 */
public class LoginReq {

    private String username;
    private String password;
    private String imgCode;

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
