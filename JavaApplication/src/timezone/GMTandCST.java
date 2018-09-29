package timezone;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by admin on 2018/6/2.
 */
public class GMTandCST {


    /**
     * Sat Jun 02 17:20:02 CST 2018
     * 2018-06-02 17:20:02
     */
    @Test
    public void test1(){
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }

    /**
     * Sat Jun 02 17:23:27 CST 2018
     * 2018-06-02 17:23:27
     */
    @Test
    public void test2(){
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // CST(北京时间)在东8区
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(sdf.format(new Date()));
    }


    /**
     * TimeZone.getDefault():sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
     */
    @Test
    public void test3() {
        System.out.println("TimeZone.getDefault():" + TimeZone.getDefault());
    }

    @Test
    public void test4()
    {
        String a =  "*aaaaaaa";
        int i = a.indexOf("*");
        System.out.println(i);
        //System.out.println("TimeZone.getDefault():" + TimeZone.getDefault());
    }
}
