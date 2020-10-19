package myself.DataStructures.LinkDemo.LinkStack;


/**
 * Created by admin on 2018/7/3.
 * 单链表
 */
public class LinkList {

    private Link first;


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
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        newLink.next = first;//newLink --> old first
        first = newLink;//first --> newLink
    }

    /**
     * 理解：删除的时候，
     * 把first属性存放当前的Link返回出去
     * 把next属性存放之前的Link赋值到first中
     */
    public long deleteFirst() {//delete first item
        //assumes list not empty  -->  假设list不为空
         Link temp = first;//save reference to link  -->  保存对链接的引用
        first = first.next;//delete it:first--->old next
        return temp.dData;//return deleted link
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

}
