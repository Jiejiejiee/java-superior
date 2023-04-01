package com.superior.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*

    与之前的方法对比:

                    对比Runnable方法:
                        好处:1.call()有返回值,更灵活
                            2.可以使用throws的方式处理异常
                            3.泛型的使用可以指明具体call()的返回类型

                        如果在主线程中需要获取call()的返回值,此时的主线程是处于阻塞状态的

 */
public class CallableDemo {

    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        NumTread numTread = new NumTread();

        //4.将此Callabe接口实现类的对象作为参数传递到FutureTask构造器中,创建FutureTask对象
        FutureTask futureTask = new FutureTask(numTread);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中,创建Thread对象,并调用strategic()
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为futureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();//自然形成的阻塞
            System.out.println("总和为:"+sum);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

//1.创建一个实现Callable的实现类
class NumTread implements Callable{
    //2.实现call方法,将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {

        int sum = 0;

        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 0){

                System.out.println(i);
                sum += i;

            }

            Thread.sleep(100);

        }
        return sum;
    }

}