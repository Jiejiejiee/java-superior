package com.superior.test;

public class ThreadTest1 {

    public static void main(String[] args) {

        PrintEvenNumber printEvenNumber = new PrintEvenNumber();
        PrintOddNumber printOddNumber = new PrintOddNumber();

        printEvenNumber.start();
        printOddNumber.start();

    }

}

class PrintEvenNumber extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {

            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }

        }
    }
}

class PrintOddNumber extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }

        }
    }
}