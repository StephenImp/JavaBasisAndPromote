package treeMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class TestTreeMapDemo {

    public static void main(String[] args) {

        // creating maps
        TreeMap<Integer, String> treemap = new TreeMap<>();
        SortedMap<Integer, String> treemapincl;

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

//        System.out.println("Getting tail map");
//        //获取一个子集。其所有对象的 key 的值大于等于 fromKey
//        treemapincl = treemap.tailMap(3);
//        System.out.println("Tail map values: " + treemapincl);
//
//        treemapincl = treemap.headMap(3);
//        System.out.println("Head map values: " + treemapincl);
//
//        System.out.println("First key is: " + treemap.firstKey());
    }
}
