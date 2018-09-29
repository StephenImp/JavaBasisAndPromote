package DataStructures.LinkDemo.LinkStack;

/**
 * Created by admin on 2018/7/5.
 */
public class LinkStackApp {

    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(10);
        theStack.push(20);

        theStack.displayStack();

        theStack.push(30);
        theStack.push(50);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }




}
