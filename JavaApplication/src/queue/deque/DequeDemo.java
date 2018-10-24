package queue.deque;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * void push(E e):将给定元素”压入”栈中。存入的元素会在栈首。即:栈的第一个元素 E pop():将栈首元素删除并返回。
 */

public class DequeDemo {

		public static void main(String[] args) {
			
			Deque<String> deque = new LinkedList<String>();
			deque.push("a");
			deque.push("b");
			deque.push("c");
			System.out.println(deque);
			System.out.println();

			/**
			 * 使用deque是因为向双向队列中插入集合时，可以取出先插入的元素
			 */
			Collection<String> collection = new ArrayList<>();
			collection.add("d");
			collection.add("e");
			collection.add("f");

			deque.addAll(collection);
			System.out.println(deque);

			
			// 获取栈首元素后，元素不会出栈
			String str = deque.peek();
			System.out.println(str);
			System.out.println(deque);
			
			
			while (deque.size() > 0) {
				/**
				 * 获取栈首元素后，元素将会出栈
				 * pop()和poll()两种方法相同。
				 */
				//System.out.println(deque.pop());
				System.out.println(deque.poll());
			}
			
			System.out.println(deque);
		}
	}
