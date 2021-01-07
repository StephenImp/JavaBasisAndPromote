package com.cn.myself.factoyPatternModel.abstractFactoryPattern;

/**
 *  抽象工厂是用户的主入口
 *  是Spring应用的最广泛的一种设计模式
 *  易于拓展
 */
public interface CourseFactory {
    INote createNote();
    IVideo creteVideo();
}
