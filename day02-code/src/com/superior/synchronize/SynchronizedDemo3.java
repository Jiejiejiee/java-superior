package com.superior.synchronize;

public class SynchronizedDemo3 {
    /*

        使用同步方法解决上述问题

     */

    public static void main(String[] args) {

        SaleTickets3 s = new SaleTickets3();

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

class SaleTickets3 implements Runnable {

    int ticket = 100;
    //Object obj = new Object();
    static boolean isFlag = true;

    Ticket3 tickets3 = new Ticket3();

    @Override
    public void run() {

        while (isFlag) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            show();

        }
    }

    public synchronized void show(){//默认的同步监视器this.在main方法中只创建了一个对象,此this唯一

        if (ticket > 0) {

            System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket);
            ticket--;

        }else {
            isFlag = false;
        }
    }

}


class Ticket3 {

}



