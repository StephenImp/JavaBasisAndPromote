package com.cn.version2.enumDemo;

/**
 * Created by admin on 2018/8/14.
 */
public enum  PayChannelEnum {
    ALI_PAY("alipay","支付宝支付"),
    WECHAT_PAY("wechat_pay","微信支付");

    private String channel;
    private String des;

    PayChannelEnum(String channel, String des) {
        this.channel = channel;
        this.des = des;
    }

    public String getChannel() {
        return channel;
    }

    public String getDes() {
        return des;
    }
}
