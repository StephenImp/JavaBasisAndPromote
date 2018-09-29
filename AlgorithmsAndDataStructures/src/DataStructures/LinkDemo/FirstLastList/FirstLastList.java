package DataStructures.LinkDemo.FirstLastList;

/**
 * Created by admin on 2018/7/5.
 * 双端链表
 */
public class FirstLastList {

    private Link first;
    private Link last;


    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 插入头结点时，
     * 当第一次插入时，头结点和尾节点相同
     * 不是第一次插入时，只变化头结点，尾节点不变
     *
     * @param dd
     */
    public void insertFirst(long dd) {

        /**
         * 这里第一步，last和first节点都指向一个内存地址
         */
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {

        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            /**
             * last的next节点指向新的节点
             * 如果是最开始的链表，那么last.next=first
             */
            last.next = newLink;//这里first和last节点的值都发生变化？
        }
        /**
         * 这个时候，新节点就是最后一个节点
         * .next节点一直保存着上一个节点的值
         */
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
