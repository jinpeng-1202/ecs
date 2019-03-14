package com.jin.bean;

/**
 * @author jinpeng
 * @date 2019/3/11.
 */
public class User {

    private Integer id;
    private String name;

    private String addr;
    private String code;
    private String wde;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWde() {
        return wde;
    }

    public void setWde(String wde) {
        this.wde = wde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
