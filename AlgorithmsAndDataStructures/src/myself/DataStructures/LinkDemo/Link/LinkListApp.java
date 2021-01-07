package myself.DataStructures.LinkDemo.Link;

/**
 * Created by admin on 2018/7/3.
 */
public class LinkListApp {
    public static void main(String[] args) {
        LinkList theLink = new LinkList();
        theLink.insertFirst(22, 2.99);
        theLink.insertFirst(33, 3.99);
        theLink.insertFirst(55, 5.99);
        theLink.insertFirst(66, 6.99);
        theLink.insertFirst(88, 8.99);

        theLink.displayList();

        while (!theLink.isEmpty()) {
            Link aLink = theLink.deleteFirst();
            System.out.println("Delete ");
            aLink.displayLink();
            System.out.println("");
        }

        theLink.displayList();
    }
}
