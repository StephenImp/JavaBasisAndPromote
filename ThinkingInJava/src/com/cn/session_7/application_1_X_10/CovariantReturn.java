package com.cn.session_7.application_1_X_10;

/**
 * 协变返回类型。
 * 父类的引用指向子类的实例。
 * 它表示在导出类中的被覆盖方法可以返回基类方法的返回类型的某种导出类型。
 */
public class CovariantReturn {

    public static void main(String[] args) {

        Mill m = new Mill();

        // 这里产生的基类对象
        Grain g = m.process();
        System.out.println(g);

        m = new WheatMill();
        //这里是产生的子类对象
        g = m.process();
        System.out.println(g);
    }

}
