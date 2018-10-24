package com.cn.sectionOne.exampleOne.Before;

import com.cn.sectionOne.exampleOne.Before.entity.Customer;
import com.cn.sectionOne.exampleOne.Before.entity.Movie;
import com.cn.sectionOne.exampleOne.Before.entity.Rental;

import java.util.Enumeration;

/**
 * Created by admin on 2018/6/7.
 */
public class ReconsitutionBefore {
    /**
     * 这是一个影片出租店的程序：
     * 计算每一位顾客的消费金额并打印详单
     * 操作者告诉程序：顾客租了哪些影片，租期多长，程序便根据租赁时间和影片类型算出费用
     * 影片分为三类：普通片，儿童片和新片
     * 除了计算费用，还要为常客计算积分，积分会根据租片种类是否为新片而有所不同
     */

    public String statament() {

        double totalAmount = 0;//总价
        int frequentRenterPoints = 0;//积分

        Customer customer = new Customer();

        Enumeration rentals = customer.get_rentals().elements();//?

        String result = "Rental Record for" + customer.get_name() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line(循环判断)
            switch (each.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_daysRented() > 2) {
                        thisAmount += (each.get_daysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.get_daysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.get_daysRented() > 3) {
                        thisAmount += (each.get_daysRented() - 3) * 1.5;
                    }
                    break;
            }

            //add grequent renter points
            frequentRenterPoints++;

            //add bonus for a two day  new release rental
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE)
                    && each.get_daysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result += "Amount owed  is " + String.valueOf(totalAmount) +"\n" ;
            result += "You earend" +String .valueOf(frequentRenterPoints) +"frequent renter points";
            return  result;
        }
        return result;
    }
}
