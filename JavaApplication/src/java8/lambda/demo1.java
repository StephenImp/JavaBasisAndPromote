package java8.lambda;

/**
 * Created by MOZi on 2019/2/26.
 */
public class demo1 {

    //匿名内部类
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello world!!!");
        }
    };

    //lambda    表达式
    Runnable r2 = () -> System.out.println("Hello World!!!");


}
