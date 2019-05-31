package com.cn.LambdaDemo.demo1.exercise;

import com.cn.LambdaDemo.demo1.Employee;
import com.cn.LambdaDemo.demo1.FilterEmployeeForAge;
import com.cn.LambdaDemo.demo1.FilterEmployeeForSalary;
import com.cn.LambdaDemo.demo1.MyPredicate;
import org.junit.Test;

import java.util.*;

/**
 * Created by MOZi on 2019/2/28.
 */
public class LambdaExercise {


    @Test
    public void exerciseOne(){

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);

    }

    @Test
    public void exerciseTwo(){

        Comparator<String> comparator =   (x,y)->Integer.compare(x.length(),y.length());

        TreeSet<String> ts = new TreeSet<>(comparator);

    }


    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void exerciseThree(){

        List<Employee> list = filterEmployeeAge(emps);

    }

    private List<Employee> filterEmployeeAge(List<Employee> emps) {

        List<Employee> list = new ArrayList<>();

        for (Employee employee:emps){
            if (employee.getAge()<18){

                list.add(employee);
            }
        }
        return list;
    }


    /**
     * 使用策略模式
     */
    @Test
    public void exerciseFour(){

        List<Employee> list = filterEmployeeAge(emps,new FilterEmployeeForAge());

    }

    private List<Employee> filterEmployeeAge(List<Employee> emps, FilterEmployeeForAge filterEmployeeForAge) {

        List<Employee> list = new ArrayList<>();

        for (Employee employee:emps){
            if (filterEmployeeForAge.test(employee)){
                list.add(employee);
            }
        }
        return list;

    }


    @Test
    public void exerciseFive(){

        List<Employee> list = filterEmployee(emps,new FilterEmployeeForSalary());

    }

    private List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> myPredicate) {

        List<Employee> list = new ArrayList<>();

        for (Employee employee:emps){
            if (myPredicate.test(employee)){
                list.add(employee);
            }
        }
        return list;

    }


    @Test
    public void exerciseSix(){

        List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
        list.forEach(System.out::println);

    }






}
