package enumExercise.case4;

public enum Signal {
    RED(1,"红"),
    YELLOW(2,"黄"),
    GREEN(3,"蓝");

    private int code;
    private String desc;

    Signal(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
