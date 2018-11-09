package DataStructures.Tree234;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by MOZi on 2018/11/8.
 */
public class Tree234App {

    public static void main(String[] args) throws Exception {

        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true){
            System.out.println("Enter first letter of");
            System.out.println("show,inset ,or find:");

            char choice = getChar();

            switch (choice){
                case 's':
                    theTree.displayTree();;
                    break;
                case 'i':
                    System.out.println("Enter value to insert:");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found!=-1){
                        System.out.println("Found"+value);
                    }else {
                        System.out.println("Could not find"+value);
                    }
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar()throws Exception{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt()throws Exception{
        String s  = getString();
        return Integer.parseInt(s);
    }
}
