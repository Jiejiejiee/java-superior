package com.superior.deadlock.lock;


import java.util.concurrent.locks.ReentrantLock;

/*

    1.创建lock的实例,确保多个线程公用同一个lock实例 ---> static声明
    2.执行lock方法lock(),
    3.释放对共享数据的锁定unlock()

 */
public class LockDemo {
    public static void main(String[] args) {

        SaleTickets1 s = new SaleTickets1();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}

class SaleTickets1 implements Runnable {

    int ticket = 100;

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            //由于unlock()容易导致循环不结束的问题,考虑用try-catch-finally结构

            try {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }

                reentrantLock.lock();

                if (ticket > 0) {


                    System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket);
                    ticket--;

                } else {
                    break;
                }
            } finally {
                reentrantLock.unlock();
            }

        }

    }
}

