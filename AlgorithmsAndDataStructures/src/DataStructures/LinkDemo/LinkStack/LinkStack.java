package DataStructures.LinkDemo.LinkStack;

/**
 * Created by admin on 2018/7/5.
 */
public class LinkStack {

    private LinkList theList;

    public LinkStack(){
        theList = new LinkList();
    }

    public void push(long j){
        theList.insertFirst(j);
    }

    public long pop(){
        return theList.deleteFirst();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void displayStack(){
        System.out.println("Stack(top-->bottom):");
        theList.displayList();
    }

}
