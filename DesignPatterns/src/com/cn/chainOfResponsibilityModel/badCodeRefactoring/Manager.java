package com.cn.chainOfResponsibilityModel.badCodeRefactoring;

/**
 * Created by admin on 2018/8/16.
 * 管理者
 */
public abstract class Manager {

    protected String name;

    /**
     * 管理者的上级
     */
    protected Manager superior;

    public Manager() {
    }

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    /**
     * 申请请求
     */
    abstract public void requestApplications(Request request);

}
