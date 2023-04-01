package com.superior.throwable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ExceptionDemo {
    /*

        异常:可以编写针对性的代码进行处理

                编译时异常(受检异常):在执行javac.exe命令时出现的异常

                运行时异常(非受检异常):在执行java.exe时出现的异常

     */

    public static void main(String[] args) throws IOException {

        //运行时异常
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();

        //编译时异常
        demo8();

    }

    //ArrayIndexOutOfBoundsException,数组越界异常
    public static void demo1(){
        int[] arr = new int[10];
        System.out.println(arr[10]);
    }

    //NullPointerException,空指针异常
    public static void demo2(){

//        String str = "hello";
//        str = null;
//        System.out.println(str.toString());

//        int[] arr = new int[10];
//        arr = null;
//        System.out.println(arr[0]);

        int[][] arr = new int[10][];
        System.out.println(arr[0][0]);

    }

    //ClassCastException,类型转换错误
    public static void demo3(){

        Object obj = new String();
//        String str = (String) obj;
        Date date = (Date) obj;

    }

    //NumberFormatException,数字格式异常
    public static void demo4(){
        String str = "123";
        str = "abc";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    //InputMismatchException,输入类型不匹配
    public static void demo5(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);

    }

    //ArithmeticException,算数异常
    public static void demo6(){

        int num = 10;
        System.out.println(num / 0);

    }

    //Unhandled exception: java.lang.ClassNotFoundException
    public static void demo7(){

        //Class<?> clz = Class.forName("java.lang.String");

    }

    //Unhandled exception: java.io.FileNotFoundException
    //Unhandled exception: java.io.IOException
    //Unhandled exception: java.io.IOException
    public static void demo8() throws FileNotFoundException, IOException {

        File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day01-code\\src\\com\\superior\\throwable\\hello.txt");

        FileInputStream fis = new FileInputStream(file);//可能报FileNotFoundException
        int data = fis.read();//可能报IOException

        while (data != -1){
            System.out.println((char) data);
            data = fis.read();//可能报IOException
        }

        fis.close();//可能报IOException

    }


}
