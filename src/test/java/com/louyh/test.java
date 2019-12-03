package com.louyh;

import com.louyh.m.util.Utils;
import org.joda.time.DateTime;

import java.util.Date;

public class test {
    public static void main(String[] args) {
//        int year = 2020;
//        int month = 1;


        //43920
        //43921
        //3

        //43435
        //43770
        //6
//        int sum = Utils.getSumYear(2020);
//        System.out.println(sum);
//        int asum = Utils.getSumYear(2019);
//        System.out.println(asum);
//        System.out.println(sum - asum);
//        String date = "2019-3-1";
//        Date date1 = Utils.stringToDate(date, "yyyy-MM-dd");
//        System.out.println(Utils.sdfdate.format(date1));

        Long date =1588262400000l;
        DateTime dateTime = new DateTime(date);
        System.out.println(dateTime.toString(Utils.sdf));
        DateTime dateTime1 = dateTime.plusDays(-7);
        System.out.println(dateTime1.toString(Utils.sdf));
        DateTime dateTime2 = dateTime.plusDays(37);
        System.out.println(dateTime2.toString(Utils.sdf));
    }
}
