package DataStructures.LinkDemo.FirstLastList;

/**
 * Created by admin on 2018/7/5.
 */
public class FirstLastApp {

    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(11);
        theList.insertFirst(33);
        theList.insertFirst(55);

        theList.insertLast(22);
        theList.insertLast(66);
        theList.insertLast(88);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
