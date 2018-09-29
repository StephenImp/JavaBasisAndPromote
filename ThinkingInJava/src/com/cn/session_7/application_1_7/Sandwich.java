package com.cn.session_7.application_1_7;

/**
 * 构造器与多态
 *
 *   构建器的调用遵照下面的顺序：
     (1) 调用基础类构建器。这个步骤会不断重复下去，
         首先得到构建的是分级结构的根部，然后是下一个衍生类，等等。直到抵达最深一层的衍生类。
     (2) 按声明顺序调用成员初始化模块。
     (3) 调用衍生构建器的主体。
 */
public class Sandwich extends ProtableLunch{

    private Bread b = new Bread();
    private Chesse c = new Chesse();
    private Lettuce l = new Lettuce();
    
    public Sandwich(){
        System.out.println("Sandwich()");
    }
    
    public static void main(String[] args) {
        new Sandwich();
    }
}
