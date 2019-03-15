package com.jin.common.enums;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
public enum  ResCode {

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    NEEd_AUTHORITIES(201, "无权访问!"),
    NOT_LOGIN(202, "未登录!"),
    LOGIN_FAILURE(203, "登录失败"),
    SYSTEM_ERROR(999, "系统异常");

    private Integer code;
    private String msg;

    ResCode(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
