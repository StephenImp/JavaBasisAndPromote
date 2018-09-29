package com.cn.decorativeModel.decorative2;

import org.junit.Test;

/**
 * 体会：
 * 像是给各个子类分先后顺序调用一样。
 */
public class TestDecorative2 {

    @Test
    public void TestExample(){
        
        Person xc = new Person("小蔡");
        
        System.out.println("第一种装扮");
        
        WearSneakers wsk = new WearSneakers();//破球鞋
        wsk.Decorate(xc);

        BigTrouser bt =new BigTrouser();//垮裤
        bt.Decorate(wsk);
        
        bt.Show();
        
        System.out.println("---------------------------------------");
        
        TShirts ts = new TShirts();//大T恤
        ts.Decorate(xc);

        WearSuit ws = new WearSuit();//西装
        ws.Decorate(ts);

        ws.Show();
        
    }
}
