package clone;

/**
 * Created by admin on 2018/8/31.
 *
 * 对于值类型的数据是可以通过“=”来实现复制的。
 * 但是对于引用类型的对象，“=”只能复制其内存地址，使对象的引用指向同一个对象，而不会创建新的对象。
 * clone则可以创建与原来对象相同的对象。
 */
public class TestCloneOne implements Cloneable {

    private int i;

    /**
     * 代码测试部分
     * @param args
     */
    public static void main(String[] args){

        TestCloneOne sample = new TestCloneOne(10);
        System.out.println("i: " + sample.i);
        TestCloneOne sampleCopy = (TestCloneOne) sample.clone();
        sampleCopy.i++;
        System.out.println("copy i: " + sampleCopy.i);
        System.out.println("i: " + sample.i);
    }


    public TestCloneOne(int i) {
        this.i = i;
    }

    //重写clone
    @Override
    public Object clone(){
        Object o = null;
        try {
            o = super.clone();   //调用父类的clone
        } catch (CloneNotSupportedException e) {    //异常捕获
            e.printStackTrace();
        }
        return o;
    }
}
