package testProblem;

import java.math.BigDecimal;

/**
 * Created by MOZi on 2018/12/25.
 *
 * 保留两位小数
 */
public class TestFloat {

    public static void main(String[] args) {

        //解决冲突
        Float total = new Float(93.0);
        Float total2 = new Float(94.0);
        Float total3 = new Float(96.0);

        double t =(total*0.3+total2*0.5+total3*0.2);

        BigDecimal bg = new BigDecimal(t);

        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.println(t);

        System.out.println(f1);



    }
}
