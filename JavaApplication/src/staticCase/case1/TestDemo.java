package staticCase.case1;


/**
 *  当调用A,a的时候，A已经被加载了并且被初始化了，所以就加载了静态代码块，
 *  但是并没有调用其中的静态方法，所以静态方法并没有用被调用
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(A.a);
    }
}
