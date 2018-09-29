package com.cn.gubao.version1.factory;

import com.cn.gubao.version1.FilterInterface.PayProcessor;
import com.cn.gubao.version1.features.AliPay;
import com.cn.gubao.version1.features.WechatPay;

/**
 * Created by admin on 2018/8/14.
 */
public class PayFactory {

    public static PayProcessor getPayProcessor(String type) {

        switch (type) {
            case "alipay":
                return new AliPay();
            case "wechatpay":
                return new WechatPay();
            default:
                throw new RuntimeException("未找到合适的支付渠道");
        }
    }
}
