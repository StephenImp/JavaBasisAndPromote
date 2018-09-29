package threadLocal.demo1;

import java.util.concurrent.TimeUnit;

//不使用本地线程变量
public class Main9 {

	public static void main(String[] args) {

		UnsafeTask task = new UnsafeTask();

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(task);
			thread.start();

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
