package com.cn.myself.appointModel;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeB  doing ..." + command);
    }
}
