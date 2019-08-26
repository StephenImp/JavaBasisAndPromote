package com.cn.StreamAPI.trapCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *  1.为什么parallelStorage的大小不固定？
 *  2.为什么parallelStorage会有null元素？
 *
 *  其实我们可以认为ArrayList内部维护了一个数组Arr其定义一个变量 n用以表式这个数组的大小
 *  那么向这个ArrayList中存储数据的过程可以分解为这么几步：
 *
 *  1).读取数组的长度存入n
 *  2.)向这个数组中储入元素arr[n]=a
 *  3).将n+1
 *  4).保存n
 *  而对于parrallelStorage元素数量不固定的原因就是多线程有可能同时读取到相同的下标n同时赋值，
 *  这样就会出现元素缺失的问题了
 *
 *
 *  解决方法①
 *  Collections.synchronizedList(new ArrayList<>())
 *  在使用并行流的时候是无法保证元素的顺序的，也就是即使你用了同步集合也只能保证元素都正确但无法保证其中的顺序。
 *
 *  解决方法②
 *  .collect(Collectors.toList());
 *
 */
public class trapDemo1 {
    @Test
    public void test1() {

        /**
         * 有问题
         */
        //List<Integer> listOfIntegers = new ArrayList<>();
        //List<Integer> parallelStorage = new ArrayList<>();

        /**
         * 解决 方式①
         */
        List<Integer> listOfIntegers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());


        for (int i = 0; i < 100; i++) {
            listOfIntegers.add(i);
        }

        listOfIntegers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .forEach(i -> parallelStorage.add(i));
        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Sleep 1 sec");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }

    @Test
    public void test2() {

        //List<Integer> listOfIntegers = new ArrayList<>();
        List<Integer> listOfIntegers = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 100; i++) {
            listOfIntegers.add(i);
        }

        //List<Integer> parallelStorage = new ArrayList<>();
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
                .parallelStream()
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));
    }

    /**
     * 解决方法②
     *
     * 不光没有出现Null和数量不一致问题，还排序了！
     * 所以，在采用并行流收集元素到集合中时，最好调用collect方法，一定不要采用Foreach方法或者map方法。
     */
    @Test
    public void test3(){
        List<Integer> listOfIntegers = new ArrayList<>();
        for (int i = 0; i <100; i++) {
            listOfIntegers.add(i);
        }

        List<Integer> parallelStorage = listOfIntegers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());//解决

        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println("Sleep 2 sec");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

    }

}
