package com.cn.sectionOne.exampleOne.After.entity;

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

    public double getCharge() {
        double result = 0;
        //determine amounts for each line(循环判断)
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (get_daysRented() > 2) {
                    result += (get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (get_daysRented() > 3) {
                    result += (get_daysRented() - 3) * 1.5;
                }
                break;
            default:
        }
        return result;
    }
}
