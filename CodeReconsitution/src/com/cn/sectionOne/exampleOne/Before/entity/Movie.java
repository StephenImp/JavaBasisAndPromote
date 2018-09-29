package com.cn.sectionOne.exampleOne.Before.entity;

/**
 * Created by admin on 2018/6/7.
 * 电影
 */
public  class  Movie {
    public static final int CHILDRENS = 2;//儿童
    public static final int REGULAR = 0;//普通
    public static final int NEW_RELEASE = 1;//新片

    private String _title;//标题
    private int _priceCode;//价格

    public Movie() {
    }

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}
