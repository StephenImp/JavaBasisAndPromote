package enumExercise.case8;

import enumExercise.case4.Signal;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/**
 * EnumMap 是专门为枚举类型量身定做的 Map 实现。
 * 虽然使用其它的 Map 实现（如HashMap）也能完成枚举类型实例到值得映射，
 * 但是使用 EnumMap 会更加高效：它只能接收同一枚举类型的实例作为键值，并且由于枚举类型实例的数量相对固定并且有限，
 * 所以 EnumMap 使用数组来存放与枚举类型对应的值。
 * 这使得 EnumMap 的效率非常高。
 */
public class EnumMapDemo {
    public static void main(String[] args) {

        // EnumMap的使用
        System.out.println("EnumMap展示");
        EnumMap<Signal, String> errMap = new EnumMap(Signal.class);
        errMap.put(Signal.RED, "红灯");
        errMap.put(Signal.YELLOW, "黄灯");
        errMap.put(Signal.GREEN, "绿灯");
        for (Iterator<Map.Entry<Signal, String>> iter = errMap.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<Signal, String> entry = iter.next();
            System.out.println(entry.getKey().name() + " : " + entry.getValue());
        }

    }
}
