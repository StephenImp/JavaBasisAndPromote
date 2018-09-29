package DataStructures.Stack;

/**
 * Created by admin on 2018/6/29.
 */
public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX() {
    }

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public static void main(String[] args) {
        StackX s = new StackX(6);
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        s.push('e');
        s.push('f');

        while (!s.isEmpty()){
            long value = s.pop();
            System.out.println(value);
            System.out.println("");
        }

        System.out.println("");
    }
}
