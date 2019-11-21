package UncaughtExceptionHandlerDemo.problemOne;

import org.junit.Test;

import java.util.Observable;

/**
 * 直接try{}catch(){}  直接在外面捕获线程是有问题的，因为和子线程不是一个线程
 *
 * 但是在各个子线程中捕获线程是没有问题的。
 *
 */
public class TestProblem extends Observable {

    @Test
    public void test(){

        for (int i = 2; i >0 ; i--) {
            new Thread(()->{
                int j = 1;
                int k = 0;
                int m = j/k;
            }).start();
        }
    }


    @Test
    public void testOne(){

        try {
            for (int i = 3; i >0 ; i--) {
                new Thread(()->{
                    int j = 1;
                    int k = 0;
                    int m = j/k;
                }).start();
            }

        }catch (Exception e){
            System.out.println("测试捕获线程中的异常信息...");
            super.setChanged();
            notifyObservers(this);
        }

    }

}
