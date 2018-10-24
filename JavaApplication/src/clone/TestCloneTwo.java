package clone;

/**
 * Created by admin on 2018/8/31.
 * 用来比较深拷贝和浅拷贝
 */
public class TestCloneTwo {

    Shallow shallow;
    Deep deep;

    public TestCloneTwo() {
        shallow = new Shallow();
        deep = new Deep();
    }

    public static void main(String[] args){

        TestCloneTwo sampleDiff = new TestCloneTwo();
        TestCloneTwo sampleDiffCopy = (TestCloneTwo) sampleDiff.clone();

        /**
         * 改变之前的输出
         */
        System.out.println("sampleDiff.shallow.tempShallow: " + sampleDiff.shallow.tempShallow);
        System.out.println("sampleDiff.deep.tempDeep: " + sampleDiff.deep.tempDeep);

        System.out.println("sampleDiffCopy.shallow.tempShallow: " + sampleDiffCopy.shallow.tempShallow);
        System.out.println("sampleDiffCopy.deep.tempDeep: " + sampleDiffCopy.deep.tempDeep);


        /***
         * 改变tempClass和tempClone属性
         */
        sampleDiffCopy.shallow.tempShallow++;
        sampleDiffCopy.deep.tempDeep++;

        System.out.println("====================================");

        /**
         * 改变之后的输出
         */
        System.out.println("sampleDiff.shallow.tempShallow: " + sampleDiff.shallow.tempShallow);
        System.out.println("sampleDiff.deep.tempDeep: " + sampleDiff.deep.tempDeep);

        System.out.println("sampleDiffCopy.shallow.tempShallow: " + sampleDiffCopy.shallow.tempShallow);
        System.out.println("sampleDiffCopy.deep.tempDeep: " + sampleDiffCopy.deep.tempDeep);



    }


    @Override
    public Object clone() {

        TestCloneTwo o = null;
        try {

            o = (TestCloneTwo) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        /**
         * 注意观察这里
         */
        o.deep = (Deep) o.deep.clone();

        return o;
    }
}


/**
 * 实现了Cloneable
 */
class Shallow implements Cloneable{

    int tempShallow;

    public Shallow() {
        tempShallow = 10;
    }

    @Override
    public Object clone() {

        Object o = new Object();
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }
}

/**
 * 实现了Cloneable
 */
class Deep implements Cloneable{

    int tempDeep;

    public Deep() {
        tempDeep = 20;
    }

    @Override
    public Object clone(){
        Object o = new Object();
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;

    }
}
