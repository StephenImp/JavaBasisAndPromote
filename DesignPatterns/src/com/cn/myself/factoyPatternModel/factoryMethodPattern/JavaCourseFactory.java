package com.cn.myself.factoyPatternModel.factoryMethodPattern;

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
