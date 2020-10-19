package com.cn.myself.factoyPatternModel.abstractFactoryPattern;

public class JavaNote implements INote {

    @Override
    public void edit() {
        System.out.println("编写java笔记");
    }
}
