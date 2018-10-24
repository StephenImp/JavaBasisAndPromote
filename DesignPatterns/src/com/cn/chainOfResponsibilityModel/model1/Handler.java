package com.cn.chainOfResponsibilityModel.model1;

/**
 * Created by admin on 2018/8/16.
 */
public abstract class Handler {

    protected Handler successor;

    /**
     * 设置继任者
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理请求的抽象方法
     */
    public abstract void handleRequest(int request);

}
