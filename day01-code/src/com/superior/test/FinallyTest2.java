package com.superior.test;

public class FinallyTest2 {

    public static void main(String[] args) {

        int result = test(5);
        System.out.println(result);//5

    }

    public static int test(int num) {

        try {
            return num;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return num--;
        } finally {
            System.out.println("test方法结束");
            //finally中存在return语句,则返回finally中的return值
            ++num;
        }
    }

}
