package com.cn.appointModel;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeA  doing ..."+command);
    }
}
