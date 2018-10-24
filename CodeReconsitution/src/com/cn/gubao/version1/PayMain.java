package com.cn.gubao.version1;

import com.cn.gubao.version1.context.PayContext;
import com.cn.gubao.version1.factory.PayFactory;

/**
 * Created by admin on 2018/8/14.
 */
public class PayMain {
    public static void main(String[] args) {

        PayContext p = new PayContext();
        PayFactory.getPayProcessor("alipay").processor(p);
    }
}
