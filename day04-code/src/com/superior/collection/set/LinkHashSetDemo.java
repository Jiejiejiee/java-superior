package com.superior.collection.set;

import com.other.Person;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*

    LinkHashSet是HashSet的子类,在现有的数组+单向链表+红黑树结构的基础上,又添加了一组双向链表,用来记录添加元素的先后顺序

        可以按照添加元素的顺序遍历,便于频繁的查询操作

 */
public class LinkHashSetDemo {

    @Test
    public void test1(){

        Set set = new LinkedHashSet();

        set.add("AA");
        set.add(123);
        set.add("BB");
        Person p = new Person("Tom",23);
        set.add(p);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());//遍历顺序与添加顺序一致
        }

    }

}
