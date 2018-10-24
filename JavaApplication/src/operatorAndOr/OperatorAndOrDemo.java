package operatorAndOr;

/**
 * Created by admin on 2018/7/3.
 */
public class OperatorAndOrDemo {

    /**
     * &&  ||
     */
    public static void main(String[] args) {
        if (iAmTrueNo1()||iAmTrueNo2()&&iAmFalse()) {
            System.out.println("Main:Result is true");
        } else {
            System.out.println("Main:Result is false");
        }
    }

    /**
     *   |  &
     */
//    public static void main(String[] args) {
//        if (iAmFalse()|iAmTrueNo2()&iAmTrueNo1()) {
//            System.out.println("Main:Result is true");
//        } else {
//            System.out.println("Main:Result is false");
//        }
//    }


    private static boolean iAmTrueNo1() {
        System.out.println("Has invoked! I'm iAmTrueNo1()");
        return true;
    }

    private static boolean iAmTrueNo2() {
        System.out.println("Has invoked! I'm iAmTrueNo2()");
        return true;
    }

    private static boolean iAmFalse() {
        System.out.println("Has invoked! I'm iAmFalse()");
        return false;
    }
}
