package DataStructures.Stack.applicationTwo;

import DataStructures.Stack.StackX;

/**
 * Created by admin on 2018/7/2.
 */
public class BracketChecher {

    private String input;

    public BracketChecher() {
    }

    public BracketChecher(String in) {
        this.input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int j = 0; j < stackSize; j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if (ch == '}' && chx != '{' ||
                                ch == ']' && chx != '[' ||
                                ch == ')' && chx != '(') {
                            System.out.println("Error:" + ch + "at" + j);
                        }
                    }else{
                        System.out.println("Error:" + ch + "at" + j);
                    }
                    break;
                default:
                    break;
            }
        }

        if(!theStack.isEmpty()){
            System.out.println("Error:missing right delimiter");
        }
    }
}
