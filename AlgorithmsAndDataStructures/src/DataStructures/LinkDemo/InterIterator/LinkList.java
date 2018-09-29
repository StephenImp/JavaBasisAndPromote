package DataStructures.LinkDemo.InterIterator;


/**
 * Created by admin on 2018/7/9.
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link f) {
        first = f;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public DataStructures.LinkDemo.InterIterator.ListIterator getIterator() {
        return new DataStructures.LinkDemo.InterIterator.ListIterator(this);
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;//最右侧节点的上一个节点为新的最右侧节点
        }
        System.out.println("");
    }
}
