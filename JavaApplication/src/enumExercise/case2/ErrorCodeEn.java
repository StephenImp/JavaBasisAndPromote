package enumExercise.case2;

/**
 * 基操
 */
public enum  ErrorCodeEn {

    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    ErrorCodeEn(int number, String description) {
        this.code = number;
        this.desc = description;
    }

    private int code;
    private String desc;


    public int getCode() {
        return code;
    }
    public String getDescription() {
        return desc;
    }
    public static void main(String args[]) { // 静态方法
        for (ErrorCodeEn s : ErrorCodeEn.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
        }
    }
}
