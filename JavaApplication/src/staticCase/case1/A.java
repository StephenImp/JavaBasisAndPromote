package staticCase.case1;

public class A {

    public static String a = "test";

    A(){
        System.out.println("A的构造器");
    }

    static {
        System.out.println("A的静态代码块!!!");
    }

    public static void func(){
        System.out.println("A 中的静态方法被调用!!!");
    }

}
