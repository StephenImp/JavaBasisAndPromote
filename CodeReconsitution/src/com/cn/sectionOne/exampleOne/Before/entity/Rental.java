package com.cn.sectionOne.exampleOne.Before.entity;

/**
 * Created by admin on 2018/6/7.
 * 租赁
 */
public class Rental {

    //Rental表示每个顾客租了一部影片

    private Movie _movie;
    private int _daysRented;//租用的天数

    public Rental() {
    }

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public void set_daysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }
}
