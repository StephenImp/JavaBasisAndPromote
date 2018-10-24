package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018\9\16 0016.
 * <p>
 * ？ 1 - 9
 * ？ + ？ = ？
 * <p>
 * 已使用的数字不能重复
 * eg: 2 + 2 = 4  false
 * 2 有重复
 */
public class Demo1 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        int min = 1;
        int max = 9;
        int result;
        int count = 0;

        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {

                if (i == j ) {
                    continue;
                }
                result = i + j;
                list.add(result);
                System.out.println("i = "+i+"&&&j = "+j+"###result = "+result);
                count++;
            }
        }

        System.out.println("count"+count);


//        for (Integer i : list) {
//            System.out.println(i);
//        }
    }

}
