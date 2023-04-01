package com.superior.test;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        Space space = new Space();

        Producer pro1 = new Producer(space);
        Producer pro2 = new Producer(space);

        Consumer con1 = new Consumer(space);
        Consumer con2 = new Consumer(space);

        pro1.setName("生产者1");
        pro2.setName("生产者2");

        con1.setName("消费者1");
        con2.setName("消费者2");

        pro1.start();
        pro2.start();

        con1.start();
        con2.start();

    }

}

class Producer extends Thread{

    private Space space;

    Producer(Space space){
        this.space = space;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        while (true){

            System.out.println("生产者开始生产...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

            space.addProduct();

        }

    }
}

class Consumer extends Thread{

    private Space space;

    Consumer(Space space){
        this.space = space;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        while (true){

            System.out.println("消费者消耗产品...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

            space.minusProduct();

        }


    }
}

class Space{
    private int productNum = 0;

    //增加方法
    public synchronized void addProduct(){

        if (productNum < 20){

            productNum++;
            System.out.println(Thread.currentThread().getName()+":生产了第"+productNum+"个产品");

            //唤醒
            notify();

        }else {

            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }
    }

    //减少方法
    public synchronized void minusProduct(){

        if (productNum > 0){

            System.out.println(Thread.currentThread().getName()+"消费了第"+productNum+"个产品");
            productNum--;

            //唤醒
            notify();

        }else {

            try {
                wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }

    }

}