package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2018/7/6.
 */
public class TestList {

    @Test
    public void test1() {

        List<String> list = new ArrayList<String>();

        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");

        //foreach:list中不能直接删除元素
        for (String l : list) {
            if(l.equals("AA")){
                list.remove("AA");
            }
        }

    }

    @Test
    public void test2(){

        List<String> list = new ArrayList<String>();

        list.add("AA");
        list.add("BB");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");

        /**
         * 普通for循环
         * 不会报错，但是删除有问题
         */

        for(int i = 0;i<list.size();i++){
            if(list.get(i).equals("BB")){
                //list.remove("BB");
                list.remove(list.get(i));
            }
        }

        for(String s :list){
            System.out.println(s);
        }
    }

    @Test
    public void test3(){

        List<String> list = new ArrayList<>();

        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.equals("CC")){
                //list.remove("CC");这样直接删元素有问题
                iterator.remove();//直接用iterator删除没问题
                //list.remove(s);//这样删除也是有问题
            }
        }

        for(String s :list){
            System.out.println(s);
        }
    }
}
