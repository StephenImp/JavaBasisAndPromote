package DataStructures.HashTable.LinkAddress;


/**
 * Created by admin on 2018/7/6.
 */
public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }


    /**************************************************************************************************/

    /**
     * 在链表上移动时，需要用一个previous引用，这样才能把前一个链接点的next字段指向新的链接点
     * 当不是向链表插入第一条数据或者插入的数据比头结点数据小的时候
     * previous = current or  previous.next = newLink
     * <p>
     * Link previous = null 判断是否在表头
     */
    public void insert(Link theLink) {

        int key = theLink.getKey();
        Link previous = null;//previous(前) 用来判断是否仍在表头
        Link current = first;//头结点为当前节点

        /**
         * 当插入第二条数据时,因为current每次都重新指向first，
         * first此时已经有值
         * 同时需要满足 key > current.dData 才会进循环
         *
         * 这里的逻辑真他妈的牛逼。。
         */
        while (current != null && key > current.dData) {
            previous = current;//这个时候，previous在表尾
            current = current.next;//前一个节点的下一个节点为当前节点
        }
        /**
         * 插入第一条数据时，或者 key < current.dData
         */
        if (previous == null) {
            first = theLink;//头结点为新节点
        } else {
            /**
             * 只有进入while循环时，才能进到这里来
             */
            previous.next = theLink;//因为current向后移了以为,previous就为尾节点的上一个节点
        }
        //每一次新节点的next节点指向当前节点
        theLink.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
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

    public Link find(int key) {
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SortedList{" +
                "first=" + first +
                '}';
    }
}
