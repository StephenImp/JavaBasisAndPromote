package com.cn.session_6.application_3_2;

/**
 * Created by admin on 2018/7/31.
 * 空白final
 * 声明空白的final变量是没有问题的，再赋值也可以。但是如果没有地方赋值的话，编译会报错。
 */
class BlankFinal {
    final int i = 0; // Initialized final
    final int j; // Blank final
    final Poppet p; // Blank final handle

    // Blank finals MUST be initialized
    // in the constructor:
    BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet();
    }

    BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet();
    }

    public static void main(String[] args) {
        BlankFinal bf = new BlankFinal();
        System.out.println(bf.j);
    }
}
