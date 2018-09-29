package com.cn.session_6.application_1_1;

/**
 * 个人总结：
 * 重写类中的toString方法，在类的实例被打印时，被调用
 */
public class Bath {

    private String s1 = "Happy", s2 = "Happy", s3, s4;

    public static void print(Object s) {
        System.out.println(s);
    }

    private Soap castille;
    private int i;
    private float toy;

    public Bath() {
        print("Inside Bath()");
        s3 = "joy";
        toy = 3.14f;
        castille = new Soap();

    }

    {
        i = 47;
    }

    public String getS4() {
        return s4;
    }

    public String toString(){
        if(s4 == null){
            s4="joy";
        }

      return
              "s1 = " +s1+"\n"+
              "s2 = " +s2+"\n"+
              "s3 = " +s3+"\n"+
              "s4 = " +s4+"\n"+
              "i = " +i+"\n"+
              "toy = " +toy+"\n"+
              "castille = " +castille+"\n";
    }

    public static void main(String[] args) {
        Bath b = new Bath();

        String s = b.s4;
        System.out.println("before:s--->"+s);//null

        //调用print()之、前,属性s4并没有被赋值
        System.out.println("before:s.get()--->"+b.getS4());//null

        //调用print()时，它会填充s4，使所有字段在使用之前都获得正确的初始化。
        System.out.println(b);

        //单纯打印一个类的属性，就算有值，也不会被打印出来
        System.out.println("after:s--->"+s);//null

        //调用print()之后,通过get()方法是可以获取值的
        System.out.println("after:s.get()--->"+b.getS4());//joy

        Soap castille = b.castille;
        String ss = castille.getS();

        System.out.println(ss);


    }

}
