package com.cn.decorativeModel.decorative1;

/**
 * 
 ************************************************************
 * @类名 : Decorator.java
 *
 * @DESCRIPTION : Decorator装饰    装饰抽象类
 * @AUTHOR :  admin
 * @DATE :  2017年9月14日
 ************************************************************
 */
abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        if(component != null){
            component.Operation();
        }
    }

}
