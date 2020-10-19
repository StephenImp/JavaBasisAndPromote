package com.cn.myself.appointModel;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String,IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("指令A",new EmployeeA());
        targets.put("指令B",new EmployeeB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
