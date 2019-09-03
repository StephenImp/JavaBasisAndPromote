package enumExercise.case3;

/**
 * 枚举可以实现接口
 * enum 可以像一般类一样实现接口。
 *
 * 同样是实现上一节中的错误码枚举类，通过实现接口，可以约束它的方法。
 */
public enum ErrorCodeEn2 implements INumberEnum{

    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    ErrorCodeEn2(int number, String description) {
        this.code = number;
        this.description = description;
    }

    private int code;
    private String description;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
