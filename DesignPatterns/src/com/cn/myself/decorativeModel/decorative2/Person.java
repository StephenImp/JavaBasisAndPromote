package com.cn.myself.decorativeModel.decorative2;

public class Person {

    public Person() {
    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void Show() {
        System.out.println("装扮的人" + name);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
    
}
