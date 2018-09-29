package com.cn.session_7.application_3_4;

/**
 * Created by admin on 2018/8/2.
 */
public interface Selector {

    boolean end();

    Object current();

    void next();
}
