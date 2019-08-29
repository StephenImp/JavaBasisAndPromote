package com.cn.session_4between5.application_3;

/**
 * this:表示对“调用方法的那个对象”的引用。
 * this关键字的用法和其他对象引用并无不同，
 * 但要注意：如果在方法内部调用同一个类的另一个方法，就不必使用this，直接调用即可。
 * 当前方法中的this引用会自动应用于同一类中的其他方法。
 */
public class Leaf {

    int i =0;

    Leaf increment(){
        i++;
        return this;
    }

    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }

}
