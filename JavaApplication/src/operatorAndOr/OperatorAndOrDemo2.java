package operatorAndOr;

import org.junit.Test;

/**
 * Created by admin on 2018/7/3.
 */
public class OperatorAndOrDemo2 {

    @Test
    public void test1(){
        int i=0;
        if(10!=10&(i++)==1){
        }else{
            System.out.print("结果为假     "+i);
        }
    }

    @Test
    public void test2(){
        int i=0;
        if(10!=10&&(i++)==1){

        }else{
            System.out.print("结果为假     "+i);
        }
    }

    @Test
    public void test3(){
        int i=0;
        if(10==10|(i++)!=0){
            System.out.print("结果为真     "+i);
        }else{
        }
    }

    @Test
    public void test4(){
        int i=0;
        if(10==10||(i++)!=0){
            System.out.print("结果为真     "+i);
        }else{
        }
    }
}
