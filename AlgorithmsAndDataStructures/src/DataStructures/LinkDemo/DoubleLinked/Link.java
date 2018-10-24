package DataStructures.LinkDemo.DoubleLinked;

/**
 * Created by admin on 2018/7/5.
 */
public class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + "");
    }

    @Override
    public String toString() {
        return "Link{" +
                "dData=" + dData +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
