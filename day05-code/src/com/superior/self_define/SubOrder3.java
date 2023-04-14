package com.superior.self_define;

/*

        泛型类的继承:
        SubOrder3是泛型类
        父类中的泛型参数确定,但子类的泛型参数不确定

 */
public class SubOrder3<E> extends Order<Integer> {

    E e;

    public SubOrder3() {
    }

    public SubOrder3(E e) {
        this.e = e;
    }

    //父类中,第一个参数是T类型,继承关系中声明了该类型是Integer类型,此处直接使用Integer类型
    public SubOrder3(Integer integer, int orderId, E e) {
        super(integer, orderId);
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
