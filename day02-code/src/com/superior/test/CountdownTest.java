package com.superior.test;

public class CountdownTest {

    public static void main(String[] args) {

        for (int i = 10; i >= 0; i--) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 0) {
                System.out.println("倒计时结束!");
            } else {
                System.out.println(i);
            }

        }

    }

}
