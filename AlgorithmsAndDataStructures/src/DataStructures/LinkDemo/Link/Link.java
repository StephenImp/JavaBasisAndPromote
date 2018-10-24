package DataStructures.LinkDemo.Link;

/**
 * Created by admin on 2018/7/3.
 */
public class Link {

    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + iData + "," + dData + "}");
    }

    @Override
    public String toString() {
        return "Link{" +
                "iData=" + iData +
                ", dData=" + dData +
                ", next=" + next +
                '}';
    }
}
