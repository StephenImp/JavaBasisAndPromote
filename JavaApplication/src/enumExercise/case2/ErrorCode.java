package enumExercise.case2;

/**
 * Java 虽然不能直接为实例赋值，但是它有更优秀的解决方案：为 enum 添加方法来间接实现显示赋值。
 *
 * 创建 enum 时，可以为其添加多种方法，甚至可以为其添加构造方法。
 *
 * 注意一个细节：如果要为enum定义方法，那么必须在enum的最后一个实例尾部添加一个分号。
 * 此外，在enum中，必须先定义实例，不能将字段或方法定义在实例前面。否则，编译器会报错。
 */
public enum  ErrorCode {

    OK(0) {
        public String getDescription() {
            return "成功";
        }
    },
    ERROR_A(100) {
        public String getDescription() {
            return "错误A";
        }
    },
    ERROR_B(200) {
        public String getDescription() {
            return "错误B";
        }
    };

    private int code;

    // 构造方法：enum的构造方法只能被声明为private权限或不声明权限
    private ErrorCode(int number) { // 构造方法
        this.code = number;
    }
    public int getCode() { // 普通方法
        return code;
    } // 普通方法

    public abstract String getDescription(); // 抽象方法


    public static void main(String args[]) { // 静态方法
        for (ErrorCode s : ErrorCode.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
        }
    }
}
