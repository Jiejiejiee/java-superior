package com.superior.thread.threadsafe;

/*

    使用继承thread类实现
    售票问题:开三个窗口,售票

 */
public class ThreadSafeDemo2 {

    public static void main(String[] args) {

        SaleTickets2 s1 = new SaleTickets2();
        SaleTickets2 s2 = new SaleTickets2();
        SaleTickets2 s3 = new SaleTickets2();

        s1.setName("窗口1");
        s2.setName("窗口2");
        s3.setName("窗口3");

        s1.start();
        s2.start();
        s3.start();

    }

}

class SaleTickets2 extends Thread{

    static int ticket = 100;

    @Override
    public void run() {

        while (true){

            if (ticket > 0){

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"售票,票号为"+ticket);
                ticket--;

            }else {
                break;
            }

        }

    }
}