package com.superior.self_define;

import java.util.ArrayList;

/*

    泛型类

 */
public class Order<T> {

    //声明了类的泛型参数以后，就可以在类的内部使用此泛型参数
    T t;
    int orderId;

    //自定义泛型方法
    public <E> E method(E e){
        return null;
    }

    //定义一个泛型方法,将E[]数组元素添加到对应类型的ArrayList中,并返回;泛型方法可以声明为static
    public <E> ArrayList<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for (E e : arr){
            list.add(e);
        }

        return list;

    }

    public Order() {
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", orderId=" + orderId +
                '}';
    }

}
