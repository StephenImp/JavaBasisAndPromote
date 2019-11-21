package threadPoolAllDemo.threadPollExceptionHandler;

import java.sql.SQLException;
import java.util.Observable;

public class SimpleObservable extends Observable implements Runnable {

    public void run() {
        try {
            //System.out.println("下面进行JDBC连接");
            //int a = 100 / 0;
            throw new SQLException("JDBC连接异常。。。");
        } catch (SQLException e) {
            //处理连接异常，自动重启该线程
            System.out.println("捕获到SQL异常");
            setChanged();
            //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
            notifyObservers();
        } catch (Exception et) {
            System.out.println("出现异常");
            setChanged();
            notifyObservers();
        }
    }

}
