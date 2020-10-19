package myself.DataStructures.HashTable.OpeanAddress;

/**
 * Created by admin on 2018/7/25.
 * HashTable 的核心还是在于hash算法
 *
 * 开放地址法:通过在hash表中再寻找一个空位，解决冲突问题
 */
public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;


    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.println("Table:");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.println(hashArray[j].getKey() + "");
            } else {
                System.out.println("**");
            }
        }
        System.out.println("");
    }

    /**
     * 这个方法用来算出hash值
     * @param key
     * @return
     */
    public int hasFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {

        int key = item.getKey();
        int hashVal = hasFunc(key);

        //当数组没有值，或者没有被删除的时候（插入重复数据的时候会一直顺延）
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {

        int hashVal = hasFunc(key);

        while (hashArray[hashVal] != null) {

            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];//save item
                hashArray[hashVal] = nonItem;//delete item
                return temp;//return item
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {

        int hashVal = hasFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;  //wraparound if necessary
        }

        return null;
    }


    public static void main(String[] args) {

        HashTable h = new HashTable(20);

        DataItem data1 = new DataItem(1);
        DataItem data2 = new DataItem(2);
        DataItem data3 = new DataItem(3);
        DataItem data4 = new DataItem(4);
        DataItem data5 = new DataItem(5);
        DataItem data6 = new DataItem(6);
        DataItem data7 = new DataItem(7);
        DataItem data8 = new DataItem(8);
        h.insert(data1);
        h.insert(data2);
        h.insert(data3);
        h.insert(data4);
        h.insert(data5);
        h.insert(data6);
        h.insert(data7);
        h.insert(data8);
        h.insert(data1);

        DataItem dataItem = h.find(8);
        System.out.println(dataItem);

        h.delete(4);

        h.displayTable();

    }

}
