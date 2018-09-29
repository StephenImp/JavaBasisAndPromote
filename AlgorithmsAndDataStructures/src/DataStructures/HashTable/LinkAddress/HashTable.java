package DataStructures.HashTable.LinkAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/7/25.
 * <p>
 * 链地址法
 */
public class HashTable {

    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.println(j + ".");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {

        int hashVal = key % arraySize;
        return hashVal;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(hashVal);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(hashVal);
        return theLink;
    }


    public static void main(String[] args) {

        HashTable h = new HashTable(5);
        Link theLink1 = new Link(1);
        Link theLink2 = new Link(2);
        Link theLink3 = new Link(3);
        Link theLink4 = new Link(4);
        Link theLink5 = new Link(5);
        Link theLink6 = new Link(6);
        Link theLink7 = new Link(7);
        Link theLink8 = new Link(8);
        Link theLink9 = new Link(1);

        h.insert(theLink1);
        h.insert(theLink2);
        h.insert(theLink3);
        h.insert(theLink4);
        h.insert(theLink5);
        h.insert(theLink6);
        h.insert(theLink7);
        h.insert(theLink8);
        h.insert(theLink9);

        Link link = h.find(1);
        System.out.println("find:"+link);

        h.delete(4);
        h.displayTable();
    }
}
