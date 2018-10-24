package com.cn.gubao.version1.FilterInterface;

import com.cn.gubao.version1.context.PayContext;

/**
 * Created by admin on 2018/8/14.
 * 支付处理功能
 */
public interface PayProcessor {

    void processor(PayContext context);
}
