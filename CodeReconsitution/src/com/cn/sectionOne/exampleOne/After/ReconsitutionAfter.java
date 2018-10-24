package com.cn.sectionOne.exampleOne.After;


import com.cn.sectionOne.exampleOne.After.entity.Customer;
import com.cn.sectionOne.exampleOne.After.entity.Movie;
import com.cn.sectionOne.exampleOne.After.entity.Rental;

import java.util.Enumeration;

/**
 * Created by admin on 2018/6/7.
 */
public class ReconsitutionAfter {

    public String statament() {

        double totalAmount = 0;//总价
        int frequentRenterPoints = 0;//积分

        Customer customer = new Customer();

        Enumeration rentals = customer.get_rentals().elements();//?

        String result = "Rental Record for" + customer.get_name() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //thisAmount = each.getCharge();

            //add bonus for a two day  new release rental
            frequentRenterPoints += GetFrequentRenterPoints(each);

            //show figures for this rental
            result += "Amount owed  is " + each.getCharge() +"\n" ;
            result += "You earend" + each.getCharge() +"frequent renter points";
            return  result;
        }
        return result;
    }

    public int GetFrequentRenterPoints(Rental each){

        if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE)
                && each.get_daysRented() > 1) {
            return  2;
        }
        return 1;
    }

}
