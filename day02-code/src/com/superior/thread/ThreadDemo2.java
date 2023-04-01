package com.superior.thread;

/*

    线程创建方法2:实现runnable接口

        创建一个实现runnable接口的类
        实现接口中的run()
        创建当前实现类的对象
        将此对象作为参数传递到thread类的构造器中,创建thread类的实例
        thread类的实例调用start()

 */
public class ThreadDemo2 {

    public static void main(String[] args) {

        PrintNumber2 printNumber2 = new PrintNumber2();
        Thread thread1 = new Thread(printNumber2);
        thread1.start();

        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

        Thread thread2 = new Thread(printNumber2);
        thread2.start();

    }

}

class PrintNumber2 implements Runnable{

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 0){
                //System.out.println(i+"*");
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }

    }
}