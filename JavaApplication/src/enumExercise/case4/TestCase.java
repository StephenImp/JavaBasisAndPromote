package enumExercise.case4;

/**
 * switch 状态机
 *
 * 我们经常使用switch语句来写状态机。JDK7以后，
 * switch已经支持 int、char、String、enum 类型的参数。
 * 这几种类型的参数比较起来，使用枚举的switch代码更具有可读性。
 *
 */
public class TestCase {

    public static String getTrafficInstruct(Signal signal) {
        String instruct = "信号灯故障";
        switch (signal) {
            case RED:
                instruct = "红灯停";
                break;
            case YELLOW:
                instruct = "黄灯请注意";
                break;
            case GREEN:
                instruct = "绿灯行";
                break;
            default:
                break;
        }
        return instruct;
    }

    public static void main(String[] args) {
        getTrafficInstruct(Signal.GREEN);
    }
}
