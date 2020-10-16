package treeSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {


    /**
     * TreeSet是用compareTo()来判断重复元素的，而非equals()
     * 所以如果排序的字段和去重的字段不是同一个字段
     * 那么只能是拆分出来
     *
     * 先用Set去重
     * 转成List再去排序
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        Set<Node> sets = new TreeSet<>();

        Node node3 = new Node();
        node3.setKey("3");
        node3.setLabel("3");
        node3.setOrder(2);

        Node node = new Node();
        node.setKey("1");
        node.setLabel("1");
        node.setOrder(3);


        Node node2 = new Node();
        node2.setKey("2");
        node2.setLabel("1");
        node2.setOrder(1);


        sets.add(node);
        sets.add(node2);
        sets.add(node3);

        System.out.println(sets.size());

        sets.forEach(s->{

            System.out.println(s);

        });



//        Set<Node> sets = new HashSet<>();
//
//        Node node = new Node();
//        node.setKey("1");
//        node.setLabel("2");
//        node.setOrder(1);
//
//
//        Node node2 = new Node();
//        node2.setKey("1");
//        node2.setLabel("2");
//        node2.setOrder(2);
//
//
//        sets.add(node);
//        sets.add(node2);
//
//        System.out.println(sets.size());



    }
}
