package com.zhou.web;

import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;


/**
 * java8推出了java.time包,包括新的处理时间的类来解决问题
 *
 */
public class TestTime {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2018, 7, 26);
        LocalDate localDate2 = LocalDate.now();
        System.out.println( localDate2);


        int year = localDate1.getYear();
        Month month = localDate1.getMonth();
        int day = localDate1.getDayOfMonth();
        DayOfWeek dow = localDate1.getDayOfWeek();
        int len = localDate1.lengthOfMonth();

        // 是否闰年
        boolean leap = localDate1.isLeapYear();

        System.out.println(year);
        System.out.println(month.getValue());
        System.out.println(day);
        System.out.println(dow.getValue());
        System.out.println(len);
        System.out.println(leap);

        // 通过传递 TemporalField 来换取时间 类似于工厂模式
        // ChronoField此枚举实现了TemporalField接口
//        int fieldYear = localDate1.get(ChronoField.YEAR);
//        int fieldMonth = localDate1.get(ChronoField.MONTH_OF_YEAR);
//        int fieldDay = localDate1.get(ChronoField.DAY_OF_MONTH);
//        System.out.println(fieldYear);
//        System.out.println(fieldMonth);
//        System.out.println(fieldDay);

    }
}
