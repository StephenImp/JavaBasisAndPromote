package com.cn.version2.context;

/**
 * Created by admin on 2018/8/14.
 */
public class PayContext {

    private int cents;

    private String msg;

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayContext{" +
                "cents=" + cents +
                '}';
    }
}
