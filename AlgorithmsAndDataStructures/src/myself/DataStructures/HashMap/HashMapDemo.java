package myself.DataStructures.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/8/22.
 */
public class HashMapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap(10);
        map.put(1, "Jack");
        System.out.println(map.get(1));
        System.out.println("jack".hashCode());
    }
}
