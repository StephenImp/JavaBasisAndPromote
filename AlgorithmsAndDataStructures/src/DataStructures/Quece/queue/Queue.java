package DataStructures.Quece.queue;

/**
 * Created by admin on 2018/7/2.
 */
public class Queue {

    /**
     * 循环队列，环绕式处理
     */

    private int maxSize;//队列的最大容量
    private long[] queArray;
    private int front;//队列移除元素的下标(队头)
    private int rear;//队列的下标（队尾）
    private int nItems;//队列当前元素的个数

    public Queue() {
    }

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        //当队列的当前下标为队列的最大值时，将此下标移到队列最开始的位置
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
     }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int Size() {
        return nItems;
    }

}
