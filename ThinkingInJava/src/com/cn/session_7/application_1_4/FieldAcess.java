package com.cn.session_7.application_1_4;

/**
 * 缺陷：域与静态方法
 */
public class FieldAcess {

    public static void main(String[] args) {

        /**
         * 当Sub对象转型为Super引用时，任何域访问操作都将由编译器解析，因此不是多态的。
         * 在本例中，为sup.field和sub.field分配了不同的存储空间。
         * 这样，Sub实际上包含了两个称为field的域：它自己的和它从Super得到的。
         * 然而，在引用Sub中的field时所产生的默认域并非Super版本的field域。
         * 因此，为了得到Super.field,必须显式地指明super.field
         *
         *
         * 但一般在实际的开发过程中，属性都是private，获得属性的值都是通过方法来调用，实际意义并不明显
         */
        Super sup = new Sub();
        System.out.println("sup.field = " + sup.field + ",sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ",sub.getField() = " + sub.getField() + ",sub.getSuperField() = " + sub.getSuperField());

    }
}
