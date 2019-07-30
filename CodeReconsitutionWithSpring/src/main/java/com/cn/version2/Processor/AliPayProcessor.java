package com.cn.version2.Processor;

import com.cn.version2.FilterInterface.AbstractPayProcessor;
import com.cn.version2.context.PayContext;
import com.cn.version2.enumDemo.PayChannelEnum;

/**
 * Created by admin on 2018/8/14.
 */
//@Service
public class AliPayProcessor extends AbstractPayProcessor {

    /**
     * 非公共校验
     * @param context
     * @return
     */
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
        System.out.println("执行支付宝支付，请求参数："+context);
    }

    @Override
    public String getPayChannel() {
        return PayChannelEnum.ALI_PAY.getChannel();
    }
}
