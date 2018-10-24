package com.cn.version2;

import com.cn.version2.FilterInterface.PayProcessor;
import com.cn.version2.context.PayContext;
import com.cn.version2.enumDemo.PayChannelEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/8/14.
 */
@Configuration
@ComponentScan("com.cn.version2")
public class PayMethodDemo {

    public static void main(String[] args) {

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PayMethodDemo.class);

        PayContext payContext = new PayContext();
        payContext.setCents(100000);



        /**
         * 容器在加载WechatPayProcessor，AliPayProcessor和AbstractPayProcessor时，
         * 由于payChannelMap是静态属性，
         * AbstractPayProcessor.init() 会先将值放入payChannelMap中，所以这里可以直接取了
         * 那么这个payChannelMap.put(getPayChannel(),this);就他妈精髓了。
         * 子类的加载会同时加载它的父类，加载init方法时，会把子类的实例存入payChannelMap中。
         */

        PayProcessor.payChannelMap.get(PayChannelEnum.ALI_PAY.getChannel()).processor(payContext);

    }
}
