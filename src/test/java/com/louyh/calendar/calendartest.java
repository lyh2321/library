package com.louyh.calendar;

import com.louyh.m.util.Utils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class calendartest {


    public static int year = Integer.MIN_VALUE;

    public static int month = Integer.MIN_VALUE;

    private static int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
//        InputYearAndAay(); //输入年月
//        printBiaotou();  //打印表头
//        printCanlender(); //打印日历
        String date = "20190810";


        DateTime dateTime = Utils.sdfdatee.parseDateTime(date);

        System.out.println(Utils.sdfdatee.parseDateTime(date).toString(Utils.sdfdate));
    }

    public static Integer lastMonth() {
        int md = 0;
        if (month == 1) {
            md = 12;
        } else {
            md = month - 1;
        }

        if (md == 2) {
            return Judge(year) ? 29 : 28;
        }

        return m[md - 1];
    }

    public static Integer nextMonth() {
        int md = 0;
        if (month == 12) {
            md = 1;
        } else {
            md = month + 1;
        }

        if (md == 2) {
            return Judge(year) ? 29 : 28;
        }

        return m[md - 1];
    }

    //打印日历
    private static void printCanlender() {
        int sum = getSumYear();
        sum += getSumMonth();
        int count = sum % 7;

        sum++;
        for (int i = 0; i <= count; i++) {
            int md = lastMonth();
            System.out.print(md - count + i + "\t");
        }

        for (int i = 1; i <= m[month - 1]; i++) {
            System.out.print(i + "\t");
            if (sum % 7 == 6) System.out.print("\n");
            sum++;
        }

    }

    //计算year总天数
    private static int getSumYear() {
        int sum = 0;
        for (int i = 1900; i < year; i++) {
            sum += 365;
            if (Judge(year))
                sum++;
        }
        return sum;
    }

    //计算month的总天数
    private static int getSumMonth() {
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += m[i];
        }
        if (Judge(year) && month > 2)
            sum++;
        sum++;       //要计算1900年到year年month—1的天数
        return sum;
    }

    //打印表头
    private static void printBiaotou() {
        String[] mon = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        String[] week = {"星期一 ", "星期二 ", "星期三 ", "星期四 ", "星期五 ", "星期六 ", "星期日"};
        System.out.println(year + "年" + "  " + mon[month - 1]);
        for (int i = 0; i < 7; i++)
            System.out.print(week[i] + "\t");
        System.out.println();
    }

    //输入年月
    private static void InputYearAndAay() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        year = input.nextInt();
        System.out.print("请输入月份：");
        month = input.nextInt();
        input.close();
        input = null;
    }

    //判断是否闰年
    private static boolean Judge(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }


}