package com.cn.factoyPatternModel.abstractFactoryPattern;

public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录入python视屏");
    }
}
