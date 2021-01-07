package myself.DataStructures.LinkDemo.Link;

/**
 * Created by admin on 2018/7/3.
 * 单链表
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * make new link
     * .next引用指向前一个Link（创建的第一个Link的话，next指向first）
     * first指向当前新创建的Link
     * <p>
     * <p>
     * 理解:next属性存放之前的Link
     * first属性存放当前的Link
     */
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;//newLink --> old first
        first = newLink;//first --> newLink
    }

    /**
     * 理解：删除的时候，
     * 把first属性存放当前的Link返回出去
     * 把next属性存放之前的Link赋值到first中
     */
    public Link deleteFirst() {//delete first item
        //assumes list not empty  -->  假设list不为空
        Link temp = first;//save reference to link  -->  保存对链接的引用
        first = first.next;//delete it:first--->old next
        return temp;//return deleted link
    }

    public void displayList() {
        System.out.println("Link (first-->last): ");
        Link current = first;//这里的first应该是链表的最后一个节点  nice
        while (current != null) {
            current.displayLink();
            current = current.next;//.next是往前推一个节点
        }
        System.out.println("");
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }

            /**
             * 当链接点为第一个节点时
             */
            if (current == first) {
                first = first.next;
            } else {
                /**
                 * 因为current和previous 同时指向堆中的 first指向的地址
                 * 所以current与previous指向的地址值发生变化时，first的值同时发生变化
                 *
                 * 如果要删除当前的节点，必须把前一个连接点和后一个连接点连在一起
                 * 这里应该是前一个节点的指针定向当前节点的下一个节点
                 */
                previous.next = current.next;
            }
        }
        return current;
    }

}
