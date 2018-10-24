package com.cn.classLoading.load.loader.assignment;

/**
 * Created by MOZi on 2018/10/24.
 *
 * 动态分派(重写)
 */
public class DynamicDispatch {

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human{

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human{

        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();

    }

}
