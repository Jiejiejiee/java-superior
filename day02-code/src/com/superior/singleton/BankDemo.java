package com.superior.singleton;

/*

    实现线程安全的懒汉式

 */
public class BankDemo {

    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                b1 = Bank.getInstance();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

    }

}

class Bank {

    private Bank() {

    }

    private static volatile Bank instance = null;//避免指令重排,将变量instance声明为volatile

    //实现线程安全的方法1
//    public static synchronized Bank getInstance(){//默认为当前类Bank.class
//
//        if (instance == null){
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.getStackTrace();
//            }
//
//            instance = new Bank();
//
//        }
//
//        return instance;
//
//    }

    //实现线程安全的方法2
//    public static Bank getInstance() {//默认为当前类Bank.class
//
//        synchronized (Bank.class) {
//            if (instance == null) {
//
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.getStackTrace();
//                }
//
//                instance = new Bank();
//
//            }
//            return instance;
//        }
//
//    }

    //实现线程安全的方法3
    public static Bank getInstance() {//方法3相较于方法1和方法2,效率更高

        //当第一个进程进入同步代码块后,instance已经被创建,后续进来的线程不需要任何操作(优化)
        if (instance == null)
            synchronized (Bank.class) {
                if (instance == null) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }

                    instance = new Bank();//TODO:存在问题:指令同台.解决方法:volatile关键字

                }
            }
        return instance;
    }

}