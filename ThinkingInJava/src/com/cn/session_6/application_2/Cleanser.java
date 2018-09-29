package com.cn.session_6.application_2;

public class Cleanser {

    private String s = "Cleanser+";

    public static void print(Object s) {
        System.out.println(s);
    }

    public void append(String a) {
        s += a;
        // s = s+a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        print(x);
    }
}
