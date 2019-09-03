package enumExercise.case1;

/**
 *
 * enum 入门介绍
 *
 * 除了不能继承，基本上可以将 enum 看做一个常规的类。
 *
 *
 * values()：返回 enum 实例的数组，而且该数组中的元素严格保持在 enum 中声明时的顺序。
 *
 * name()：返回实例名。
 *
 * ordinal()：返回实例声明时的次序，从0开始。
 *
 * getDeclaringClass()：返回实例所属的 enum 类型。
 *
 * equals() ：判断是否为同一个对象。
 *
 * 可以使用 == 来比较enum实例。
 *
 * 此外，java.lang.Enum实现了Comparable和 Serializable 接口，所以也提供 compareTo() 方法。
 *
 */
public class EnumMethodDemo {

    enum Color {RED, GREEN, BLUE;}
    enum Size {BIG, MIDDLE, SMALL;}

    public static void main(String args[]) {

        /**
         *  values()  返回enum实例的数组
         *  该数组中的元素严格保持在enum中声明时的顺序
         *
         *  ordinal()
         *  元素下标，从0开始
         */
        System.out.println("=========== Print all Color ===========");
        for (Color c : Color.values()) {
            System.out.println(c + " ordinal: " + c.ordinal());
        }


        System.out.println("=========== Print all Size ===========");
        for (Size s : Size.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
        }


        System.out.println("*********************************************");

        Color green = Color.GREEN;
        System.out.println("green name(): " + green.name());//实例名称  GREEN
        System.out.println("green getDeclaringClass(): " + green.getDeclaringClass()); //返回实例所属的enum类型   class enumExercise.EnumMethodDemo$Color
        System.out.println("green hashCode(): " + green.hashCode());
        System.out.println("green compareTo Color.GREEN: " + green.compareTo(Color.GREEN));// 0
        System.out.println("green equals Color.GREEN: " + green.equals(Color.GREEN)); //true
        System.out.println("green equals Size.MIDDLE: " + green.equals(Size.MIDDLE)); //false
        System.out.println("green equals 1: " + green.equals(1)); //false
        System.out.format("green == Color.BLUE: %b\n", green == Color.BLUE); //false
    }
}
