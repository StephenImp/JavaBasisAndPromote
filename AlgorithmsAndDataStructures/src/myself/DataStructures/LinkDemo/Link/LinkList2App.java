package myself.DataStructures.LinkDemo.Link;

/**
 * Created by admin on 2018/7/4.
 */
public class LinkList2App {

    /**
     * 这个app好像有问题
     * @param args
     */
    public static void main(String[] args) {
        LinkList theList = new LinkList();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(33, 3.99);
        theList.insertFirst(55, 5.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        Link f = theList.find(33);
        if (f != null) {
            System.out.println("Found link with key" + f.iData);
        } else {
            System.out.println("Can't find link");
        }

        Link d = theList.delete(66);
        if (d != null) {
            System.out.println("Delete link with key" + d.iData);
        }else{
            System.out.println("Can't delete link");
        }

        Link d1 = theList.delete(66);
        if (d1 != null) {
            System.out.println("Delete link with key" + d1.iData);
        }else{
            System.out.println("Can't delete link");
        }

        theList.displayList();
    }


}
