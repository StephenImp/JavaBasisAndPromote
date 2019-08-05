package staticCase.case2;


/**
 * 这样虽然类被加载，但是没有进行初始化
 * 不初始化则不会执行static块。
 */
public class TestDemo {

    Class[] classArray = {
            B.class//这样引用该类，必然需要将该类加载到虚拟机中，（反射机制）
    };
    public static void main(String[] args){
        System.out.println("hello word");
    }
}
