package com.cn.sectionOne.exampleOne.After.entity;

import java.util.Vector;

/**
 * Created by admin on 2018/6/7.
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();//租金

    public Customer() {
    }

    public Customer(String _name, Vector _rentals) {
        this._name = _name;
        this._rentals = _rentals;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Vector get_rentals() {
        return _rentals;
    }

    public void set_rentals(Vector _rentals) {
        this._rentals = _rentals;
    }
}
