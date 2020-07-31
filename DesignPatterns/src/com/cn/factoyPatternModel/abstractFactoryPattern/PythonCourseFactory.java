package com.cn.factoyPatternModel.abstractFactoryPattern;

/**
 *  抽象工厂是用户的主入口
 *  是Spring应用的最广泛的一种设计模式
 *  易于拓展
 */
public class PythonCourseFactory implements CourseFactory{

    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo creteVideo() {
        return new PythonVideo();
    }
}
