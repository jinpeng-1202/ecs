package com.jin.bean;

import java.io.Serializable;

/**
 * @author jinpeng
 * @date 2019/3/13.
 */
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1747338039607366814L;

    private Integer code;

    private String message;

    private Object data;

    public ApiResponse() {
        this.code = 200;
        this.message = "success";
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
