package com.cn.gubao.version1.features;

import com.cn.gubao.version1.FilterInterface.PayProcessor;
import com.cn.gubao.version1.context.PayContext;

/**
 * Created by admin on 2018/8/14.
 */
public class WechatPay implements PayProcessor{

    @Override
    public void processor(PayContext context) {
        System.out.println("执行微信支付。。。"+context.getCents());
    }
}
