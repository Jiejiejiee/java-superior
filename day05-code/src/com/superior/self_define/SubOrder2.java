package com.superior.self_define;

/*

    泛型类的继承:
        SubOrder2是泛型类
        相当于继承了父类中不确定的泛型参数

 */
public class SubOrder2<T> extends Order<T> {

    public void show(T t){

        System.out.println(t);

    }

}
