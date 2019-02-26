package java8.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by MOZi on 2019/2/26.
 */
public class demo2 {



    public static void main(String[] args) {

        //使用匿名内部类作为参数进行传递
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });


     //Lambda 表达式作为参数进行传递
        TreeSet<String> treeSet1 = new TreeSet<>(
                ((o1, o2) -> Integer.compare(o1.length(),o2.length()))
        );

    }

}
