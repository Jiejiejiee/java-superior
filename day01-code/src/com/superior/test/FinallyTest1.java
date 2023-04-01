package com.superior.test;

public class FinallyTest1 {

    public static void main(String[] args) {

        int result = test("123");
        System.out.println(result);

    }

    public static int test(String str){

        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return -1;//再返回
        }finally {
            System.out.println("test方法结束");//先执行finally中的语句
            //若finally中也存在return语句,则直接返回finally中的return值
            //return 0;
        }

    }

}
