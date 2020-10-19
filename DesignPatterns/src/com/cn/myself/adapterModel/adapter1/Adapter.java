package com.cn.myself.adapterModel.adapter1;

/**
 * Created by admin on 2018/8/16.
 * 通过在内部包装一个Adaptee对象，把源接口转换成目标接口。
 */
public class Adapter extends Target {

    /**
     * 建立一个私有的Adaptee对象
     */
    private Adaptee adaptee = new Adaptee();


    /**
     * 这样表面上是调用Request()
     * 实际上是调用SpecificRequest()
     */
    @Override
    public void Request(){
        adaptee.SpecificRequest();
    }

}
