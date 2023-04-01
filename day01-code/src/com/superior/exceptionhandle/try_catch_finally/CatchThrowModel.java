package com.superior.exceptionhandle.try_catch_finally;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CatchThrowModel {
    /*

        抓抛模型:try-catch-finally

            抛:在程序执行的过程当中,一旦出现异常,就会在出现异常的代码处,生成对应异常类的对象,并将此对象抛出
                    一旦抛出,此程序就不执行其后的代码了

            抓:针对于过程中抛出的异常对象,进行捕获处理.一旦将异常进行了处理,代码就可以继续执行

            基本结构:

                        try{
                            ...
                            ...//可能产生异常的代码块
                        }
                        catch(异常类型1){
                            ...//当产生异常类型1型异常时的处置措施
                        }
                        catch(异常类型2){
                            ...//当产生异常类型2型异常时的处置措施
                        }
                        finally{
                            ...//无论是否发生异常,都无条件执行的语句

            细节:
                如果声明了多个catch结构,不同类型的异常不存在子父类关系的情况下,catch的位置不分前后;
                但如果存在多个异常类型满足子父类的关系,则子类声明必须在父类结构的上面,否则报错.

                try中声明的变量,出了try结构便无法调用


            实际运用:

                对于运行时异常:
                            开发中,通常就不进行显示的处理
                            一旦在程序的执行过程中,出现了异常,那么就根据异常的提示信息修改代码即可

                对于编译时异常:
                            一定要进行处理,否则编译不通过

     */

    public static void main(String[] args) {

        demo3();

    }

    public static void demo1() {
        /**
         * 如果声明了多个catch结构,不同类型的异常不存在子父类关系的情况下,catch的位置不分前后;
         * 但如果存在多个异常类型满足子父类的关系,则子类声明必须在父类结构的上面,否则报错.
         */

        try {
            Scanner scanner = new Scanner(System.in);

            int num = scanner.nextInt();
            System.out.println(num);
        } catch (InputMismatchException e) {
            System.out.println("出现了输入类型不匹配的异常");
        } catch (RuntimeException e) {
            System.out.println("出现了运行时错误的异常");
        }

        System.out.println("异常处理结束,代码继续运行");

    }

    public static void demo2() {

        try {
            String str = "123";
            str = "abc";

            int i = Integer.parseInt(str);

            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();//打印异常的详细信息
            System.out.println("--------------------------");
            System.out.println(e.getMessage());//获取发生异常的原因
        }

        System.out.println("异常处理结束");

    }

    public static void demo3() {

        try {
            File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day01-code\\src\\com\\superior\\throwable\\hello.txt");

            FileInputStream fis = new FileInputStream(file);//可能报FileNotFoundException
            int data = fis.read();//可能报IOException

            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();//可能报IOException
            }
            System.out.println();

            fis.close();//可能报IOException
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("读取数据结束");

    }

}
