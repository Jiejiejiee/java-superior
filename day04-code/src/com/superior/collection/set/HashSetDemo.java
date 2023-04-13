package com.superior.collection.set;

import com.other.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*

    HashSet:主要实现类,底层使用的是HashMap,即使用数组+单向链表+红黑树结构进行存储(jdk8中)

    要求元素所在的类要重写equals()和hashCode()两个方法,同时,要求equals()和hashCode()要保持一致性

 */
public class HashSetDemo {

    @Test
    public void test1(){

        Set set = new HashSet();

        set.add("AA");
        set.add(123);
        set.add("BB");
        Person p = new Person("Tom",23);
        set.add(p);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(set.contains(new Person("Tom", 23)));

    }

}
