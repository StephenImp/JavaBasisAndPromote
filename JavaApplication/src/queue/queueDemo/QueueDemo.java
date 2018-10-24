package queue.queueDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相关常用方法： 
 * boolean offer(E e):将元素追加到队列末尾,若添加成功则返回true。
 * E poll():从队首删除并返回该元素。 
 * E peek():返回队首元素，但是不删除
 */
public class QueueDemo {
	
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		
		// 追加元素
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		
		// 从队首取出元素并删除
		String poll = queue.poll();
		System.out.println(poll);
		System.out.println(queue);
		
		// 从队首取出元素但是不删除
		String peek = queue.peek();
		System.out.println(peek);
		System.out.println(queue);
		
		// 遍历队列，这里要注意，每次取完元素后都会删除，整个
		// 队列会变短，所以只需要判断队列的大小即可
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}

}
