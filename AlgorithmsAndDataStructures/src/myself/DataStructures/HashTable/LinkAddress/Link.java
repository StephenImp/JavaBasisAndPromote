package myself.DataStructures.HashTable.LinkAddress;

/**
 * Created by admin on 2018/7/5.
 */
public class Link {
    public int dData;
    public Link next;

    public Link(int d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + "");
    }

    public int getKey() {
        return dData;
    }

    @Override
    public String toString() {
        return "Link{" +
                "dData=" + dData +
                ", next=" + next +
                '}';
    }
}
