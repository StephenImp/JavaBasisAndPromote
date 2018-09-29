package com.cn.session_7.application_2_6;

/**
 * Created by admin on 2018/8/2.
 */
public interface RandVals {

    int rint = (int) (Math.random() * 10);
    long rlong = (long) (Math.random() * 10);
    float rfloat = (float) (Math.random() * 10);
    double rdouble = Math.random() * 10;
}
