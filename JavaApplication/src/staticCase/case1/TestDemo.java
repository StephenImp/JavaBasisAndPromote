package staticCase.case1;


/**
 *  当调用A,a的时候，A已经被加载了并且被初始化了，所以就加载了静态代码块，
 *  但是并没有调用其中的静态方法，所以静态方法并没有用被调用
 *
 *  但是A的构造器并没有调用,只是说明A的实例没有被创建
 *  类A的static变量被类A直接调用，会出发A中的静态代码块去执行。说明类A这时已经初始化了，
 *  但是A的实例对象并没有被创建。
 *
 *  而那些static代码块，或者是属性，被加载到方法区中
 *
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(A.a);
    }
}
