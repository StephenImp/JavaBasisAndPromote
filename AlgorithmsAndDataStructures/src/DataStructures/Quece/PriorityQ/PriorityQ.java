package DataStructures.Quece.PriorityQ;

/**
 * Created by admin on 2018/7/3.
 */
public class PriorityQ {

    /**
     * 优先级队列不像Quece类那样必须有front（队头）和rear（对尾），
     * 它的front总是nItems-1
     * rear总是等于0
     */

    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ() {
    }

    public PriorityQ(int s) {
        this.maxSize = s;
        this.queArray = new long[maxSize];
        this.nItems = 0;
    }

    /**
     * 优先级队列在插入的时候，插入的元素和之前的元素做比较，
     * 数值大的会放在前面
     */
    public void insert(long item) {
        int j;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

}
