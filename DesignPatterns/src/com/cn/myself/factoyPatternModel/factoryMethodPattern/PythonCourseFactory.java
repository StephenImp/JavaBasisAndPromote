package com.cn.myself.factoyPatternModel.factoryMethodPattern;

public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
