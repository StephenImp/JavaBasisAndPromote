package com.cn.myself.strategyModel.factory;

/**
 * CashFactory
 */
public class CashFactory {

    public static CashSuper createCashAccept(String type){
        
        //创建一个抽象类类型的变量，这样，不管new的是哪个实现类都可以引用
        CashSuper cs = null;
        
        //根据传入的类型，new一个实现类的对象
        switch(type){
            
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn("300","100");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;
            default:
                break;
        }
        
        return cs;
    }
}
