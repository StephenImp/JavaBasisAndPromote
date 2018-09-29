package com.cn.gubao.base.entity;

/**
 * Created by admin on 2018/8/14.
 */
public class Banana {

    private String color;
    private int weight;

    public Banana() {
    }

    public Banana( int weight,String color) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
