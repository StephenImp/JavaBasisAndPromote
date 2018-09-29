package com.cn.session_7.application_3_8;

/**
 * Created by admin on 2018/8/2.
 *
 *
 * 希望Event（事件）运行的时候，构建器即简单地捕获时间。
 * 同时ready()告诉我们何时该运行它。
 * 当然，ready()也可以在一个衍生类中被覆盖，将事件建立在除时间以外的其他东西上。
 * action()是事件就绪后需要调用的方法，而description()提供了与事件有关的文字信息。
 * 下面这个文件包含了实际的控制框架，用于管理和触发事件。
 * 第一个类实际只是一个“助手”类，它的职责是容纳Event 对象。可用任何适当的集合替换它。
 */
abstract public class Event {

    private long evtTime;

    public Event(long eventTime) {
        evtTime = eventTime;
    }

    public boolean ready() {
        return System.currentTimeMillis() >= evtTime;
    }

    abstract public void action();

    abstract public String description();
}
