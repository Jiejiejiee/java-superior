package com.superior.self_define;

public class SubOrder4<T,E> extends Order<T> {

    E e;

    public SubOrder4() {
    }

    public SubOrder4(T t, int orderId, E e) {
        super(t, orderId);
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
