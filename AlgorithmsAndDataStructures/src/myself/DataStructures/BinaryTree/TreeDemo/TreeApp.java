package myself.DataStructures.BinaryTree.TreeDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by admin on 2018/7/10.
 */
public class TreeApp {

    public static void main(String[] args) throws Exception {

        int value;
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        theTree.insert(12, 1.5);
        theTree.insert(27, 1.6);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.8);
        theTree.insert(33, 1.0);
        theTree.insert(87, 1.1);
        theTree.insert(91, 1.3);
        theTree.insert(97, 1.2);

        while (true) {
            System.out.println("Enter first letter of show,");
            System.out.println("insert,find,delete,or traverse");
            int choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.println("Enter value ti inset:");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.println("Found: ");
                        found.displayNode();
                        System.out.println("\n");
                    } else {
                        System.out.println("Cloud not found ");
                    }
                    System.out.println(value + '\n');
                    break;
                case 'd':
                    System.out.println("Enter value to delete:");
                    value = getInt();
                    boolean disDelete = theTree.delete(value);
                    if (disDelete) {
                        System.out.println("Delete" + value + '\n');
                    } else {
                        System.out.println("Cloud not delete ");
                    }
                    System.out.println(value + '\n');
                    break;
                case 't':
                    System.out.println("Enter type 1,2 or 3");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry\n");
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
