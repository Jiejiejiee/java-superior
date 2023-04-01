package com.superior.thread;

/*

    线程的创建方式1:继承thread类

        创建一个继承于thread类的子类
        重写thread类中的run()  -->  将此线程要执行的操作声明在此方法体中
        创建当前thread的子类对象
        通过对象调用start()方法:①启动线程②调用当前线程的run()

    数据出现交互,main()线程和PrintNumber()线程同时执行

        继承的局限性：只能实现单继承

 */
public class ThreadDemo1 {

    public static void main(String[] args) {

        /**
         * 1. 如果自己手动调用run()方法，那么就只是普通方法，没有启动多线程模式。
         *
         * 2. run()方法由JVM调用，什么时候调用，执行的过程控制都有操作系统的CPU调度决定。
         *
         * 3. 想要启动多线程，必须调用start方法。
         *
         * 4. 一个线程对象只能调用一次start()方法启动，如果重复调用了，则将抛出以上的异常“`IllegalThreadStateException`”。
         */

        PrintNumber1 printNumber1 = new PrintNumber1();
        printNumber1.start();

        //main()所在线程执行的操作
        for (int i = 1; i <= 10000; i++) {

            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }

    }

}

class PrintNumber1 extends Thread{
    @Override
    public void run() {

        for (int i = 1; i <= 10000; i++) {

            if (i % 2 == 0){
                //System.out.println(i+"*");
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }

    }
}