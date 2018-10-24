package callBack;

/**
 * 
 ************************************************************
 * @类名 : CallBack.java
 *
 * @DESCRIPTION : 这里是一个回调接口
 * @AUTHOR :  admin
 * @DATE :  2017年9月22日
 ************************************************************
 */
public interface CallBack {
    /**
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数
     * @param result 是答案 
     */

    public void solve(String result);
    
}
