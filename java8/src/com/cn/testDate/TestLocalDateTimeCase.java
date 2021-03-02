package com.cn.testDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * TestCase
 *
 * @author wupw
 * @date 2021/1/18
 */
public class TestLocalDateTimeCase {

    public static void main(String[] args) {

        /**
         * Formatter
         */
        LocalDateTime localDate = LocalDateTime .now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = localDate.format(dtf);
        System.out.println("当前时间:"+strDate);


        /**
         * Date to LocalDateTime
         */
        Date todayDate = new Date();
        LocalDateTime ldt = todayDate.toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
        System.out.println(ldt);//2019-05-16T19:22:12.773

        /**
         * LocalDateTime to Date
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        System.out.println(date);//Thu May 16 19:22:37 CST 2019




    }
}
