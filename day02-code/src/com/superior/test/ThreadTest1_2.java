package com.superior.test;

public class ThreadTest1_2 {
    /*

        创建thread类的匿名子类的匿名对象

     */

    public static void main(String[] args) {

        new Thread(){

            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                    }
                }
            }

        }.start();

        new Thread(){

            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 1){
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                    }
                }
            }

        }.start();

    }

}
