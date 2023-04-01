package com.superior.thread;

public class ThreadDemo3 {

    public static void main(String[] args) {

        PrintNumber3 printNumber3 = new PrintNumber3("线程1");
        printNumber3.setName("子线程");
        printNumber3.setPriority(Thread.MIN_PRIORITY);
        printNumber3.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 1; i <= 100; i++) {
//            if (i == 20){
//                try {
//                    printNumber3.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }

            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }

        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
        System.out.println(printNumber3.isAlive());
        System.out.println(printNumber3.getName() + ":" + printNumber3.getPriority());

    }


}

class PrintNumber3 extends Thread {

    public PrintNumber3() {

    }

    public PrintNumber3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            //使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            System.out.println(Thread.currentThread().getName() + "--->" + i + "*");

            //一旦执行此方法,就释放cpu的执行权
//            if (i % 20 == 0){
//                Thread.yield();
//            }

        }
    }
}