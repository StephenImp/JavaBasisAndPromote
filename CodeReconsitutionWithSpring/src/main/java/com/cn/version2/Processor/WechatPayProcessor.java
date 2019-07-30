package com.cn.version2.Processor;

import com.cn.version2.FilterInterface.AbstractPayProcessor;
import com.cn.version2.context.PayContext;
import com.cn.version2.enumDemo.PayChannelEnum;

/**
 * Created by admin on 2018/8/14.
 */
//不知道什么原因，编译不通过，这注释掉，反正主要是看代码逻辑
//这个当做它生效了
//@Service
public class WechatPayProcessor extends AbstractPayProcessor {

    @Override
    public boolean preCheckedContext(PayContext context) {
        if (context.getCents() <= 0) {
            context.setMsg("金额为负数，不能支付。。。");
            return false;
        }
        return true;
    }

    @Override
    public void doPay(PayContext context) {
        System.out.println("执行微信支付，请求参数："+context);
    }

    @Override
    public String getPayChannel() {
        return PayChannelEnum.WECHAT_PAY.getChannel();
    }
}
