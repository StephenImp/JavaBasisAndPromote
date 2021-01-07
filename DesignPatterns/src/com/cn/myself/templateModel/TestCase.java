package com.cn.myself.templateModel;

public class TestCase {
    public static void main(String[] args) {

        System.out.println("---Java课程---");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();


        System.out.println("---大数据课程---");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
