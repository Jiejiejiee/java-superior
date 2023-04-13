package com.superior.collection;

import com.other.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*

    迭代器:遍历集合元素


 */
public class IteratorDemo {

    @Test
    public void test1(){

        Collection collection = new ArrayList();
        Person p1 = new Person("tom",18);

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(new String("尚硅谷"));
        collection.add(p1);

        //获取迭代器对象
        Iterator iterator = collection.iterator();

        //迭代器遍历方式1:next()指针下移,并返回该指针对应元素
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
////        System.out.println(iterator.next());//NoSuchElementException

        //*迭代器遍历方式2:
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){

        Collection collection = new ArrayList();
        Person p1 = new Person("tom",18);

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(new String("尚硅谷"));
        collection.add(p1);

        //错误遍历,每次调用iterator()都会返回一个新的迭代器对象,每次都只输出第一个元素
        while (collection.iterator().hasNext()){
            System.out.println(collection.iterator().next());
        }

    }

}
