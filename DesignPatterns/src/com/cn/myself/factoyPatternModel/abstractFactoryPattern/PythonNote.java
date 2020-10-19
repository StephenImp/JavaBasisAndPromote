package com.cn.myself.factoyPatternModel.abstractFactoryPattern;

public class PythonNote implements INote {

    @Override
    public void edit() {
        System.out.println("编写python笔记");
    }
}
