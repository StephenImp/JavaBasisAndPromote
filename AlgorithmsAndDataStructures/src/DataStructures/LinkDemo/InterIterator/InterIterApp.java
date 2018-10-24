package DataStructures.LinkDemo.InterIterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by admin on 2018/7/9.
 */
public class InterIterApp {

    public static void main(String[] args) throws Exception {
        LinkList theList = new LinkList();
        ListIterator iter1 = theList.getIterator();

        long value;

        iter1.insertAfter(20L);
        iter1.insertAfter(40L);
        iter1.insertAfter(80L);
        iter1.insertAfter(60L);

        while (true) {
            System.out.println("Enter first letter of show ,reset,");
            System.out.println("next,get,before,after,delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's':
                    if (!theList.isEmpty()) {
                        theList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if (!theList.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can't go to next Link");
                    }
                    break;
                case 'g':
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned" + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'b':
                    System.out.println("Enter value to insert :");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'd':
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Delete" + value);
                    } else {
                        System.out.println("Can't delete");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }


    public static String getString() throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws Exception {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws Exception {
        String s = getString();
        return Integer.parseInt(s);
    }


}
