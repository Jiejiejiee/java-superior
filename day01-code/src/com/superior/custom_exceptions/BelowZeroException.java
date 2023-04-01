package com.superior.custom_exceptions;

public class BelowZeroException extends RuntimeException{
    /*

        自定义异常类：

            继承于现有的异常体系
            通常提供几个构造器
            提供一个全局变量

     */

    static final long serialVersionUID = -7034897190745766939L;

    public BelowZeroException(){

    }

    public BelowZeroException(String message){

    }

}
