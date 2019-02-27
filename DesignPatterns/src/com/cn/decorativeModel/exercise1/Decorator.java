package com.cn.decorativeModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class Decorator extends Component{

    private Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    void action() {
        component.action();
    }
}
