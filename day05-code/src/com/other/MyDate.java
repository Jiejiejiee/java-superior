package com.other;

public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

    //将排序方法写到类中
    @Override
    public int compareTo(MyDate o) {
        if (this.getYear() != o.getYear())
            return this.getYear() - o.getYear();
        if (this.getMonth() != o.getMonth())
            return this.getMonth() - o.getMonth();

        return this.getDay() - o.getDay();
    }
}
