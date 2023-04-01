package com.superior.synchronize;

public class SynchronizedDemo4 {
    /*

        使用同步方法解决上述问题

     */

    public static void main(String[] args) {

        SaleTickets4 s1 = new SaleTickets4();
        SaleTickets4 s2 = new SaleTickets4();
        SaleTickets4 s3 = new SaleTickets4();

        s1.setName("窗口1");
        s2.setName("窗口2");
        s3.setName("窗口3");

        s1.start();
        s2.start();
        s3.start();

    }

}

class SaleTickets4 extends Thread {

    static int ticket = 100;
    static boolean isFlag = true;

    @Override
    public void run() {

        while (isFlag) {

            show();

        }
    }

    /**
     * public synchronized void show(){
     *
     * 默认同步监视器:this,此时有三个对象:s1,s2,s3
     * 在此情景下,同步方法就不适用了.应该采用同步代码块的方式
     *
     * 或者将该方法定义为静态方法,此时this指代的是当前类SaleTickets4,也是唯一
     * 但也许考虑该方法是否适合改为静态方法
     */
    public static synchronized void show() {

        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket);
            ticket--;

        } else {
            isFlag = false;
        }

    }
}
