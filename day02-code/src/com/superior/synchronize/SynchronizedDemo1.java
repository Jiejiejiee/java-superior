package com.superior.synchronize;

/*

    使用实现runnable接口类实现
    售票问题:开三个窗口,售票

    线程同步机制:

            1.同步代码块

                synchronized(同步监视器){

                //需要同步的代码块

                }

                需要被同步的代码:操作共享数据的代码
                共享数据:多个线程需要操作的数据
                需要被同步的代码,在被synchronized包裹以后,使得一个线程在操作这些代码的过程中,其他线程必须等待
                同步监视器:俗称锁.哪个线程获得了锁,哪个线程就能执行需要被同步的代码
                同步监视器可以使用任意一个类的对象充当,但是多个线程必须用同一个同步监视器


            2.同步方法

                如果操作共享数据的代码完整的声明在了一个方法中,那么我们就可以将此方法声明为同步方法即可

                非静态的同步方法,默认监视器是this
                静态的同步方法,默认监视器是当前类本身

 */
public class SynchronizedDemo1{
    /*

        使用同步代码块解决上述问题

     */

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

class SaleTickets1 implements Runnable{

    int ticket = 100;
    //Object obj = new Object();
    Ticket1 tickets1 = new Ticket1();

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (tickets1){
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
}

class Ticket1{

}