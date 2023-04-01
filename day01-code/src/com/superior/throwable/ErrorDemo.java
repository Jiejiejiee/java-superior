package com.superior.throwable;

public class ErrorDemo {
    /*

        错误:Java虚拟机无法解决的严重性问题,如jvm系统内部错误，资源耗尽等严重问题
                一般不编写针对性代码进行处理

     */

    public static void main(String[] args) {

        //在主方法下调用主方法，直到栈内存溢出
//        main(args);//StackOverflowError

        //超过jvm内存
        byte[] arr = new byte[1024 * 1024 * 10];//OutOfMemoryError

    }

}
