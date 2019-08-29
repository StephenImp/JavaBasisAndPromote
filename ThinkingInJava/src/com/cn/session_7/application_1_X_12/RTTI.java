package com.cn.session_7.application_1_X_12;

/**
 * 下溯造型与运行期类型标识
 *
 * 这里是，衍生类的方法比基类的方法更多，这时，想要使用衍生类的方法需要强转（向下造型）。
 */
public class RTTI {

    public static void main(String[] args) {
        Userful [] x = {
                new Userful(),new MoreUserful()
        };
        x[0].f();
        x[1].g();

        Userful x1 = x[1];
        //x[1].u();
        ((MoreUserful)x[1]).u();//Downcast/RTTI

       // ((MoreUserful)x[0]).u();//Exception thrown
    }
}
