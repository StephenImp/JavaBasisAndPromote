package com.cn.session_7.application_1_9;

/**
 * 构建器内部的多态的行为
 *
 * 基类还没有构造完成，衍生类的属性还没来得及初始化
 *
 * session_6---application_2_1
 *   Art的静态代码块
     Drawing的静态代码块
     Cartoon的静态代码块
     Art的代码块
     Art constructor
     Drawing的代码块
     Drawing constructor
     Cartoon的代码块
     Cartoon constructor
     Cartoon的display()方法!
 */
public class PloyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
