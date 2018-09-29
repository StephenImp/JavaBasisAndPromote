package com.cn.decorativeModel.decorative2;

/**
 * 
 ************************************************************
 * @类名 : Finery.java
 *
 * @DESCRIPTION : 服饰（装饰类）
 * @AUTHOR :  admin
 * @DATE :  2017年9月14日
 ************************************************************
 */
public class Finery extends Person {

    protected Person component;

    /**
     * 打扮
     * @param component
     */
    public void Decorate(Person component) {
        this.component = component;
    }

    @Override
    public void Show() {
        if (component != null) {
            component.Show();
        }
    }

}
