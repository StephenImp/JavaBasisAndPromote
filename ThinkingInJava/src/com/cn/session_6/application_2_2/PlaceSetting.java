package com.cn.session_6.application_2_2;

/**
 * Created by admin on 2018/7/31.
 * 合成与继承的结合
 */
public class PlaceSetting extends Custom {

    Spoon sp;
    Fork frk;
    Knife kn;
    DinnerPlate pl;
    PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        System.out.println(
                "PlaceSetting constructor"+i);
    }
    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(0);
    }
}
