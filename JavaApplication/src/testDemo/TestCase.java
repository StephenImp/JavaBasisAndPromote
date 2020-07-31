package testDemo;

import java.util.*;
import java.util.stream.Collectors;

public class TestCase {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("3");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

}
