package com.superior.deadlock;

public class DeadLockDemo1 {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        new Thread(() -> {
            synchronized (sb1){

                sb1.append("a");
                sb2.append("1");

                //增加发生死锁的概率
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }

                synchronized (sb2){

                    sb1.append("b");
                    sb2.append("2");

                    System.out.println(sb1);
                    System.out.println(sb2);

                }

            }
        }).start();

        new Thread(() -> {
            synchronized (sb2) {

                sb1.append("c");
                sb2.append("3");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }

                synchronized (sb1) {

                    sb1.append("d");
                    sb2.append("4");

                    System.out.println(sb1);
                    System.out.println(sb2);

                }

            }
        }).start();

    }

}
