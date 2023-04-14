package com.superior.self_define;

import com.other.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

    //测试自定义的泛型类
    @Test
    public void test1() {

        //实例化时,就可以指明类的泛型参数的类型,默认为是Object
        Order order = new Order();
        //没有指明泛型参数类型,泛型对应的类型按照Object处理,但不等价于Object
        Object obj = order.getT();
        Order<Object> order1 = new Order<>();//其创建过程需要校验Object类型

        //泛型参数在指明时,不能使用基本数据类型;但是可以使用包装类代替基本数据类型
        Order<Integer> order2 = new Order<>();

        //一旦指明了类的泛型参数类型,则在泛型类中凡是使用泛型参数的位置,都替换为指定的类型
        Integer integer = order2.getT();
        System.out.println(integer);

        Order<String> order3 = new Order<>();

        String str = order3.getT();
        System.out.println(str);

    }

    //测试自定义泛型类的子类
    @Test
    public void test2() {

        //实例化SubOrder
        SubOrder subOrder1 = new SubOrder();

        //SubOrder中未指明泛型参数的类型,SubOrder不是一个泛型类;其泛型参数默认为Object
        Object obj = subOrder1.getT();


    }

    @Test
    public void test3() {

        SubOrder1 subOrder1 = new SubOrder1();

        //继承时父类指明了泛型参数的类型,子类继承时就可以获得其参数类型
        Integer integer = subOrder1.getT();

    }

    @Test
    public void test4() {

        SubOrder2<String> subOrder2 = new SubOrder2<>();

        String str = subOrder2.getT();

        subOrder2.show("A");

    }

    @Test
    public void test5() {

        SubOrder4<String,Integer> subOrder4 = new SubOrder4<>();

        String str = subOrder4.getT();
        Integer integer = subOrder4.getE();

    }

    //测试自定义泛型方法的使用
    @Test
    public void test6() {

        Order<String> order = new Order<>();

        Integer[] arr = new Integer[]{5,2,4,9,3,6,1,7};
        ArrayList<Integer> list = order.copyFromArrayToList(arr);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
