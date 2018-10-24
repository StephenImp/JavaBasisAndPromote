package com.cn.gubao.version1.features;

import com.cn.gubao.version1.FilterInterface.PayProcessor;
import com.cn.gubao.version1.context.PayContext;

/**
 * Created by admin on 2018/8/14.
 */
public class AliPay implements PayProcessor {

    @Override
    public void processor(PayContext context) {
        System.out.println("执行支付宝支付。。。"+context.getCents());
    }
}
