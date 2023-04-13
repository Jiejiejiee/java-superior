package com.superior.collection;

import com.other.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*

    foreach循环

        - foreach循环（也称增强for循环）是 JDK5.0 中定义的一个高级for循环，专门用来`遍历数组和集合`的。

        for(元素的数据类型 局部变量 : Collection集合或数组){//这里局部变量就是一个临时变量，自己命名就可以
          	//操作局部变量的输出操作
        }

        底层仍然使用的是迭代器

        注意:增强for循环的执行过程中,是将集合或数组中的元素依次赋值给临时变量,循环体中对临时变量的修改,可能不会导致原有集合或数组中元素的修改

 */
public class For_eachDemo {

    //遍历集合
    @Test
    public void test1() {

        Collection collection = new ArrayList();
        Person p1 = new Person("tom", 18);

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(new String("尚硅谷"));
        collection.add(p1);

        for (Object obj : collection) {
            System.out.println(obj);
        }

    }

    //遍历数组
    @Test
    public void test2(){

        String[] str = new String[]{"AA","BB","CC","DD"};

        for (String s : str){
            System.out.println(s);
        }

    }



}
