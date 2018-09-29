package com.cn.gubao.base.application;

import com.cn.gubao.base.entity.Apple;
import com.cn.gubao.base.entity.Banana;
import com.cn.gubao.base.interfaceFilter.IAppleFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2018/8/14.
 */
public class FilterApples {

    public static List<Apple> repos = Arrays.asList(
            new Apple(80, "green"),
            new Apple(150, "red"),
            new Apple(80, "green"),
            new Apple(120, "red"),
            new Apple(80, "green")
    );

    public static List<Banana> reposBanana = Arrays.asList(
            new Banana(80, "green"),
            new Banana(150, "yellow"),
            new Banana(80, "green"),
            new Banana(120, "yellow"),
            new Banana(80, "green")
    );


    //版本⑤
    public static<T> List<T> filterFruit(List<T> repos,IAppleFilter appleFilter) {
        List<T> result = new ArrayList<>();
        for (T t : repos) {
            if (appleFilter.obtainApple(t)) {
                result.add(t);
            }
        }
        return result;
    }



    //版本④
    //抽象（标准接口）
    //问题（思考）：根据重量去判断，重量怎么能不写死？  策略模式？
//    public static List<Apple> filterApples(IAppleFilter appleFilter) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple app : repos) {
//            if (appleFilter.obtainApple(app)) {
//                result.add(app);
//            }
//        }
//        return result;
//    }


    //版本③
//    private static List<Apple> filterAppleByWithColor(String clolr,int weight,boolean flag) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple app : repos) {
//            if (flag&&clolr.equals(app.getColor())||(!flag&&app.getWeight()>weight)) {
//                result.add(app);
//            }
//        }
//        return result;
//    }

    //版本②
//    private static List<Apple> filterAppleByWithColor(String clolr) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple app : repos) {
//            if (clolr.equals(app.getColor())) {
//                result.add(app);
//            }
//        }
//        return result;
//    }


    //版本①
//    private static List<Apple> filterGreenApple() {
//        List<Apple> result = new ArrayList<>();
//        for (Apple app : repos) {
//            if ("green".equals(app.getColor())) {
//                result.add(app);
//            }
//        }
//        return result;
//    }

}
