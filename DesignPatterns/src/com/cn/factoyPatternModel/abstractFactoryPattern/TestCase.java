package com.cn.factoyPatternModel.abstractFactoryPattern;

public class TestCase {
    public static void main(String[] args) {

        JavaCourseFactory javaCourseFactory =new JavaCourseFactory();
        javaCourseFactory.createNote().edit();


        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.createNote().edit();

    }
}
