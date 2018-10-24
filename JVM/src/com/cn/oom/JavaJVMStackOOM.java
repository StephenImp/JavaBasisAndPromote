package com.cn.oom;

import org.junit.Test;

/**
 * Created by MOZi on 2018/10/22.
 *
 * VM args:-Xss2M
 */
public class JavaJVMStackOOM {

    private void dontStop(){
        
        while (true){
        }
    }

    public void  stackLeakByThread(){

        while (true){

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                        dontStop();
                }
            });

            thread.start();
        }
    }


    @Test
    public void testDemo(){

        JavaJVMStackOOM oom = new JavaJVMStackOOM();
        oom.stackLeakByThread();
    }
}
