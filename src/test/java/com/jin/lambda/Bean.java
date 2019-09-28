package com.jin.lambda;

/**
 * @author jinpeng
 * @date 2019/4/27.
 */
public class Bean {

    private Integer id;
    private String name;
    private boolean isSuccess;
    private LamInterface lamInterface;

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

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public LamInterface getLamInterface() {
        return lamInterface;
    }

    public void setLamInterface(LamInterface lamInterface) {
        this.lamInterface = lamInterface;
    }
}
