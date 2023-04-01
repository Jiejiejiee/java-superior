package com.superior.test;

public class BankTest {

    public static void main(String[] args) {

        Banker b = new Banker();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(b);

        t1.setName("第一位储户");
        t2.setName("第二位储户");
        t3.setName("第三位储户");

        t1.start();
        t2.start();
        t3.start();

    }

}

class Banker implements Runnable{

    static int account = 50000;
    static int flag = 0;
    static boolean isFlag = true;

    @Override
    public void run() {

        while (isFlag){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (this) {

                if (flag != account){
                    flag += 500;
                    System.out.println(Thread.currentThread().getName()+"往账户中存了500元,账户现有"+flag+"元");
                }else {
                    break;
                }
            }


        }

    }
}
