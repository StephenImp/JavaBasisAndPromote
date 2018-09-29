package DataStructures.Stack.applicationOne;

import DataStructures.Stack.StackX;

/**
 * Created by admin on 2018/7/2.
 */
public class Reverser {

    private String input;
    private String output;

    public Reverser() {
    }

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            //charAt()方法返回指定索引位置的char值。索引范围为0~length()-1.
            //如: str.charAt(0)检索str中的第一个字符,str.charAt(str.length()-1)检索最后一个字符.
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output += ch;
        }

        return output;
    }


}
