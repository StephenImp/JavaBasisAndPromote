package com.cn.version2.FilterInterface;


import com.cn.version2.context.PayContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2018/8/14.
 * 支付处理功能
 */
public interface PayProcessor {

    static Map<String,PayProcessor> payChannelMap = new ConcurrentHashMap<>();

    void processor(PayContext context);
}
