package day2_queue.practice;

import java.util.Scanner;

/**
 * 2021-03-03
 * 数组模拟队列
 * @author Steph
 */
public class ArrayQueuePracticeDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }

        System.out.println("程序退出~~");
    }

}

// 使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {

    /**
     * 因此需要两个变量 front及 rear分别记录队列前后端的下标，
     * front 会随着数据输出而改变，而 rear则是随着数据输入而改变
     */

    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    // 创建队列的构造器
    // 因为第一个数据是从下标为0开始的，所以下标的初始值为-1
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[arrMaxSize];

    }

    // 判断队列是否满
    public boolean isFull() {

        if (rear == maxSize-1){

            System.out.println("队列已满。。。");
            return true;
        }

        return false;

    }

    // 判断队列是否为空
    public boolean isEmpty() {

        if (rear == front){
            System.out.println("队列为空。。。");
            return true;
        }

        return false;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()){
            System.out.println("队列已满，不能添加数据。。。");
            return;
        }

        //添加数据,rear 指针向后移动
        // 先移动指针再赋值，因为初始值为-1
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }

        // 先移动指针再赋值，因为初始值为-1
        front++;
        int n = arr[front];

        //剔除这个数
        //数组是定长的，想删除数据只有copy了，

        return n;

    }

    // 显示队列的所有数据
    public void showQueue() {

        if (!isEmpty()){
            for (int n:arr) {
                System.out.printf("%d\t",n);
            }
        }


    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {

        if (isEmpty()){
            throw new RuntimeException("队列空，不能显示");
        }

        return arr[front];
    }
}
