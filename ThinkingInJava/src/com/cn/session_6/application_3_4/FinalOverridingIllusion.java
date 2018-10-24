package com.cn.session_6.application_3_4;

/**
 * f i n a l 方法
 *
 * 之所以要使用final 方法，可能是出于对两方面理由的考虑
 *
 * 第一个是为方法“上锁”，防止任何继承类改变它的本来含义。
 * 设计程序时，若希望一个方法的行为在继承期间保持不变，而且不可被覆盖或改写，就可以采取这种做法。
 *
 * 采用final 方法的第二个理由是程序执行的效率。
 *
 * 类内所有private 方法都自动成为final。由于我们不能访问一个private 方法，
 * 所以它绝对不会被其他方法覆盖（若强行这样做，编译器会给出错误提示）。可为一个private 方法添加final 指示符，
 * 但却不能为那个方法提供任何额外的含义。
 */
public class FinalOverridingIllusion {

    public static void main(String[] args) {
        
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        
        //you can upcast
        OverridingPrivate op = op2;
        
        //But you can't call the methods
        
        //op.f();
        //op.g();//即使是向上转型，private方法也不能被句柄调用
        
        WithFinals wf = op2;
        //wf.f();
        //wf.g();
        
    }
}
