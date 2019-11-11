package closure.case2;

/**
 * 在JAVA中，内部类可以访问到外围类的变量、方法或者其它内部类等所有成员，即使它被定义成private了，
 * 但是外部类不能访问内部类中的变量。
 * 这样通过内部类就可以提供一种代码隐藏和代码组织的机制，
 * 并且这些被组织的代码段还可以自由的访问到包含该内部类的外围上下文环境。
 */
public class DemoClass1 {

    private int length =0;

    //private|public
    private class InnerClass implements ILog
    {
        @Override
        public void Write(String message) {
            //过this显式引用外围类的变量
            //DemoClass1.this.length = message.length();

            length = message.length();
            System.out.println("DemoClass1.InnerClass:" + length);
        }
    }

    public ILog logger() {
        return new InnerClass();
    }

    public static void main(String[] args){
        DemoClass1 demoClass1 = new DemoClass1();
        demoClass1.logger().Write("abc");

        //.new
        DemoClass1 dc1 = new DemoClass1();
        InnerClass ic = dc1.new InnerClass();
        ic.Write("abcde");

    }
}
