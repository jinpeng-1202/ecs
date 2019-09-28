package com.jin.design.handler;

/**
 * @author jinpeng
 * @date 2019/8/21.
 */
public abstract class Handler {

    public Handler handler;

    protected abstract void handlerRequest();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
