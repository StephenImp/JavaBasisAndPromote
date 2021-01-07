package myself.DataStructures.LinkDemo.Link.TestProblem;

import org.junit.Test;

/**
 * Created by admin on 2018/7/4.
 */
public class TestProblem {

    Student A = new Student("AA",10);

    @Test
    public void test(){

        Student B = A;

        Student C = A;

        C.setAge(30);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

    }

}
