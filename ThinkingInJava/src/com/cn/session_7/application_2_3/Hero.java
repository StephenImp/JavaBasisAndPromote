package com.cn.session_7.application_2_3;

/**
 * Created by admin on 2018/8/2.
 */
public class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {}

    @Override
    public void fly() {}
}
