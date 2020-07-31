import java.util.HashMap;
import java.util.Map;

public class testCase {

    public static void main(String[] args) {

        Map<String,String> map1 = new HashMap<>();
        map1.put("1","1");


        Map<String,String> map2 = new HashMap<>();
        map1.put("1","2");

        Map<String,String> map3 = new HashMap<>();
        map3.putAll(map1);
        map3.putAll(map2);


        for(Map.Entry<String, String> entry : map3.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }

    }
}
