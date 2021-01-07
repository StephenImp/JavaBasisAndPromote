package myself.DataStructures.Stack.applicationOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 2018/7/2.
 */
public class ReverserApp {
    public static void main(String[] args) throws IOException {

        String input;
        String output = null ;

        while (true) {
            System.out.println("Enter a String :");
            //简单点说就是把缓冲区里的数据“立即”写到输出流中去
            //清空缓冲区，并将信息立即送出！！
            System.out.flush();

            input = getString();
            if (input.equals("")) {
                break;
            }

            Reverser r = new Reverser(input);
            output = r.doRev();
            System.out.println(output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
