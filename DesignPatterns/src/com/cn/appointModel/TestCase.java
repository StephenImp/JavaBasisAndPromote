package com.cn.appointModel;

public class TestCase {

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.command("指令A",new Leader());
    }
}
