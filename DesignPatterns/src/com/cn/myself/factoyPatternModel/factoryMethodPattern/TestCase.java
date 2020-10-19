package com.cn.myself.factoyPatternModel.factoryMethodPattern;

public class TestCase {

    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();
    }


}
