package com.cn.version2.FilterInterface;

import com.cn.version2.context.PayContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by admin on 2018/8/14.
 */
@Service
public abstract class AbstractPayProcessor implements PayProcessor {

    /**
     * @PostConstruct是jdk自带的注解
     */
    @PostConstruct
    public void  init(){
        payChannelMap.put(getPayChannel(),this);
    }

    /**
     * 定义抽象模板
     *
     * @param context
     */
    @Override
    public void processor(PayContext context) {
        if (!preCheckedContext(context)) {
            context.setMsg("参数校验失败。。。");
            return;
        }
        doPay(context);
    }

    /**
     * 对参数进行校验
     */
    public abstract boolean preCheckedContext(PayContext context);


    /**
     * 执行支付方法
     */
    public abstract void doPay(PayContext context);

    /**
     * 支付渠道编码
     */
    public abstract String getPayChannel();

}
