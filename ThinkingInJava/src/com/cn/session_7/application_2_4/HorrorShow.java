package com.cn.session_7.application_2_4;

/**
 * Created by admin on 2018/8/2.
 * 通过继承扩展接口
 */
public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    public static void main(String[] args) {

        DragonZilla if2 = new DragonZilla();

        u(if2);
        v(if2);
    }
}
