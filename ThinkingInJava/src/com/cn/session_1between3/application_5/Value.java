package com.cn.session_1between3.application_5;

public class Value {

    int i;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Value other = (Value) obj;
        if (i != other.i)
            return false;
        return true;
    }


}
