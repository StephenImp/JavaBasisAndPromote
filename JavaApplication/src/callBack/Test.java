package callBack;

public class Test {


    /**
     * 所谓回调：就是A类中调用B类中的某个方法C，然后B类中反过来调用A类中的方法D，D这个方法就叫回调方法.
     *
     * Li解决完问题后需要知道给哪个类发消息
     * 继承的这个CallBack接口，应该就是面向对象思想
     * 你传进来的是哪个类的对象的实例，Li完成后就给哪个类发消息
     *
     * 这个思想不错!
     *
     * 注意：
     *    ① Wang ---> Wang implements CallBack
     *    ② Li---> public void executeMessage(CallBack callBack, String question){}
     *    ③ Wang---> li.executeMessage(Wang.this, question);
     */

    public static void main(String[]args){
        /** 
         * new 一个小李 
         */  
        Li li = new Li();  
  
        /**
         * new 一个小王
         */
        Wang wang = new Wang(li);

        /** 
         * 小王问小李问题 
         */  
        wang.askQuestion("1 + 1 = ?");  
    }  
}
