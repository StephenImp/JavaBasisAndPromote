package com.cn.session_8.application_2_1.expand1;

/**
 * Created by admin on 2018/8/3.
 */
public class Mouse {
    private int mouseNumber;

    Mouse(int i) {
        mouseNumber = i;
    }

    // Magic method:
    @Override
    public String toString() {
        return "This is Mouse #" + mouseNumber;
    }

    void print(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        System.out.println("Mouse number " + mouseNumber);
    }
}
