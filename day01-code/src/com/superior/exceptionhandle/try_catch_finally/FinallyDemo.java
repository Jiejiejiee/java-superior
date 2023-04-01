package com.superior.exceptionhandle.try_catch_finally;

import org.junit.Test;

public class FinallyDemo {
    /*

        finally:我们将一定要被执行的代码声明放在finally结构中

            无论try中或catch中是否存在仍未被处理的异常
            无论try中或catch中是否存在return语句
                    finally中声明的语句都一定要被执行(除非使用System.exit(0)终止当前正在运行的Java虚拟机)


        开发中,有一些资源,如输入流,输出流,数据库连接,socket连接等资源),在使用完后,必须显式的进行
                为了保证这类资源在使用完后关闭,可以将这些关闭操作声明在finally中

     */

    public static void main(String[] args) {

        demo1();

    }

    @Test
    public static void demo1(){

        try {
            String str = "123";
            str = "abc";

            int i = Integer.parseInt(str);

            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();

            //在catch中再写一个异常
            System.out.println(10 / 0);
        }finally {
            System.out.println("异常处理结束");
        }

        //当catch中出现错误时,该语句不执行
        System.out.println("程序结束");

    }

}
