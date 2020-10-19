package myself.DataStructures.LinkDemo.SortedList;

/**
 * Created by admin on 2018/7/6.
 */
public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 多跑两遍代码体会，完事儿,说那么多，都是屁
     * 体会：
     * 每一次比较都是在和表头去比较
     * 当交换数据的时候需要一个中间量
     */


    /**************************************************************************************************/

    /**
     *
     *  在链表上移动时，需要用一个previous引用，这样才能把前一个链接点的next字段指向新的链接点
     *  当不是向链表插入第一条数据或者插入的数据比头结点数据小的时候
     *  previous = current or  previous.next = newLink
     *
     * Link previous = null 判断是否在表头
     *
     */
    public void insert(long key) {
        Link newLink = new Link(key);
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
            first = newLink;//头结点为新节点
        } else {
            /**
             * 只有进入while循环时，才能进到这里来
             */
            previous.next = newLink;//因为current向后移了以为,previous就为尾节点的上一个节点
        }
        //每一次新节点的next节点指向当前节点
        newLink.next = current;
    }

    public Link remove() {
        Link temp = first;
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
