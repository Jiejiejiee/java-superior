package com.superior.exceptionhandle.m_throws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsDemo {
    /*

        格式:在方法的声明处,使用throws 异常类型1 , 异常类型2 ...

            public void test() throws 异常类型1 , 异常类型2...{
                ...//可能存在编译时异常
            }

        throws方法,仅是将可能出现的异常抛给了此方法的调用者,调用者仍然需要考虑如何处理异常
                throws方式不算真正意义上处理了异常

        方法重写时,异常的处理要求
        子类重写的方法抛出的异常类型可以与父类被重写的方法抛出的异常类型相同,或者父类被重写的方法被抛出的异常类型的子类

     */

    public static void main(String[] args) {//main方法中不能throws了,不能继续上抛

        //异常已被处理,可以直接调用
        method3();

    }

    //该方法可以处理异常
    public static void method3(){

        try {
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //该方法无法解决该异常,继续向上抛出异常
    public static void method2() throws IOException {

        method1();

    }

    public static void method1() throws IOException {

        File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day01-code\\src\\com\\superior\\throwable\\hello.txt");

        FileInputStream fis = new FileInputStream(file);//可能报FileNotFoundException
        int data = fis.read();//可能报IOException

        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();//可能报IOException
        }

        fis.close();//可能报IOException

    }

}
