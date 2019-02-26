package Algorithms;

/**
 * Created by MOZi on 2019/2/14.
 *
 * 递归实现输入字符串与输出字符串倒序
 *
 * 递归实现斐波那契数列
 */
public class Demo3 {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("ScannerTest, Please Enter Name:");
//
//        String str = sc.nextLine();  //读取字符串型输入
//
//        System.out.println("str:" + str );
//
//    }


    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {

            int num = func(i);
            System.out.println(num);

        }
    }

    public static int func(int i){

        if (i<2){
            return i == 0 ? 0:1 ;
        }

        return func(i-1)+func(i-2);
    }

}
