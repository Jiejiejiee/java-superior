package com.superior.thread_communication;

/*

    使用两个线程打印1-100,线程1和线程2交替打印

    wait():线程一旦执行此方法,就会进入等待状态,同时释放同步监视器的调用
    notify():一旦执行此方法,就会唤醒wait()的线程中优先级最高的那一个线程
            如果wait()多个线程的优先级相同,则随机唤醒一个.(被唤醒的进程从当初被wait()的位置继续执行)
    notifyALL():一旦执行此方法,则唤醒所有被wait()的线程

    上述三个方法的使用:1.必须是在同步代码块中
                    2.***此三个方法的调用者,必须是同步监视器***,否则会报IllegalMonitorStateException异常
                    3.此方法声明在Object类中

        TODO:Lock需要配合Condition实现线程间的通信

    wait()和sleep()
        相同点:一旦执行,都能让进程进入阻塞状态

        不同点:1.声明位置不同:wait()声明在Object类中
                            sleep()声明在Thread类中

              2.使用场景不同:wait()只能在同步代码块或同步方法中
                            sleep()可以在任何需要使用的场景

              3.使用在同步代码块或同步方法中:wait()一旦执行,会释放同步监视器
                                         sleep()一旦执行,不会释放同步代码块

              4.结束阻塞的方式:wait()到达指定时间会自动结束阻塞 或 通过被notify唤醒,结束阻塞
                              sleep()到达指定时间会自动结束阻塞

 */
public class CommunicationDemo {

    public static void main(String[] args) {

        PrintNumber p = new PrintNumber();

        Thread t1 = new Thread(p,"线程1");
        Thread t2 = new Thread(p,"线程2");

        t1.start();
        t2.start();

    }

}

class PrintNumber implements Runnable {

    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {

        while (true) {

            synchronized (this) {
//            synchronized (obj) {//IllegalMonitorStateException
                if (number <= 100) {

                    notify();//叫醒上一个被阻塞的进程
//                    this.notify();
//                    obj.notify();

                    try {
                        Thread.sleep(100);//不释放对同步监视器的调用
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //线程一旦执行此方法,就进入等待状态,会释放同步监视器
                        wait();
//                        this.wait();
//                        obj.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }

                }else {
                    break;
                }
            }

        }

    }

}
