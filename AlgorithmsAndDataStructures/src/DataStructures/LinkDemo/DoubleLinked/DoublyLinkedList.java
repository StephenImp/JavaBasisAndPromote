package DataStructures.LinkDemo.DoubleLinked;

/**
 * Created by admin on 2018/7/9.
 * insertFirst()与insertLast() 操作方向是反向的
 *
 *    最左侧                                  最右侧
 *       ---------------------------------------  link
 */
public class DoublyLinkedList {
    private Link first;//链表最右边的节点
    private Link last;//链表最左边的节点

    /**
     * next为上一个节点（向左指向）<---
     * previous为下一个节点(向右指向)--->
     */

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 向最右端插入节点时
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);

        if (isEmpty()) {
            last = newLink;//链表为空时，最左边的节点为新节点
        } else {
            first.previous = newLink;//右边的节点的下一个节点为新节点
        }
        newLink.next = first;//新节点的上一个节点为插入新节点时之前的最右边的节点
        first = newLink;//现在最右边的节点为新节点
    }

    /**
     * 向最左端插入节点时
     */
    public void insertLast(long dd) {

        Link newLink = new Link(dd);

        if (isEmpty()) {
            first = newLink;//链表为空时，最右边的节点为新节点
        } else {
            last.next = newLink;//最左端节点的上一个节点指向新的节点
            newLink.previous = last;//新节点的下一个节点指向之前的最左边的节点
        }
        last = newLink;//新节点为最左边的节点
    }

    /**
     * 从最右侧删除
     */
    public Link deleteFirst() {

        Link temp = first;
        if (first.next == null) {//最右侧节点的上一个节点为空时
            last = null;//说明最左侧的节点为空
        } else {
            first.next.previous = null;//最右侧节点上一个节点的下一个节点为空（就是最右侧的节点）
        }
        first = first.next;//最右侧节点的上一个节点变成最右侧的节点
        return temp;
    }

    /**
     * 从最左侧删除
     */
    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {//最右侧节点的上一个节点为空时
            first = null;//说明最右侧的节点为空
        } else {
            last.previous.next = null;//最左侧的下一个节点的上一个节点为null(就是删除掉最左侧的节点)
        }
        last = last.previous;//最左侧的节点为之前最左侧节点的下一个节点
        return temp;
    }

    public boolean insertAfter(long key, long dd) {

        Link current = first;
        while (current.dData != key) {//最右侧节点的值不等于key时
            current = current.next;//新插入节点的上一个节点为之前的最右侧的节点
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(dd);

        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public Link deleteKey(long key) {

        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }


    public void displayForward() {
        System.out.println("List(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.println("List(last-->first):");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

}
