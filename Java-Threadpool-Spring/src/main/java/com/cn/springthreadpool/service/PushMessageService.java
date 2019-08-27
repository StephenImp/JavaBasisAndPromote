package com.cn.springthreadpool.service;

import com.cn.springthreadpool.entity.Page;
import com.cn.springthreadpool.entity.PageViewData;
import com.cn.springthreadpool.entity.PushMessage;
import com.cn.springthreadpool.entity.QueryDto;
import org.springframework.stereotype.Service;

/**
 * 模拟业务处理
 */
@Service
public interface PushMessageService {

    Page<PushMessage> pagedQuery(QueryDto queryDto);

    /**
     * 分页查询
     */
    Page<PushMessage> messageListPage(PushMessage pushMessage);

    /**
     * 插入
     *
     * @param pushMessage
     */
    void insertMessage(PushMessage pushMessage);

    /**
     * 更新消息
     *
     * @param pushMessage
     */
    void updateMessage(PushMessage pushMessage);

    /**
     * 根据uuid查询详情
     */
    PushMessage findByUUid(String uuid);

    /**
     * 插入订单相关的消息
     */
    void insertMessage(PageViewData pageViewData);
}
