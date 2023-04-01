package com.superior.test;

public class AccountTest {

    public static void main(String[] args) {

        Account acct = new Account();

        Customer c1 = new Customer(acct, "第一位储户");
        Customer c2 = new Customer(acct, "第二位储户");
        Customer c3 = new Customer(acct, "第三位储户");

        c1.start();
        c2.start();
        c3.start();

    }

}

//不使用静态变量实现数据共享
class Account{//账户

    private double balance;

    public synchronized void deposit(double ant){

        if (ant > 0){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            balance += ant;

        }
        System.out.println(Thread.currentThread().getName()+"存了1000元,余额为"+balance);
    }

}

class Customer extends Thread{

    Account account;

    public Customer(Account acct){

    }

    public Customer(Account acct,String name){
        super(name);
        this.account = acct;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {

            account.deposit(1000);

        }

    }
}