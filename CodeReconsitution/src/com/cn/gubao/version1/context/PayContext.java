package com.cn.gubao.version1.context;

/**
 * Created by admin on 2018/8/14.
 */
public class PayContext {

    private int cents;

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    @Override
    public String toString() {
        return "PayContext{" +
                "cents=" + cents +
                '}';
    }
}
