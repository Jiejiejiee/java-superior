package com.superior.test;

import com.other.Person;
import com.other.Person1;

import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        Person1 p1 = new Person1(1001,"AA");
        Person1 p2 = new Person1(1002,"BB");

        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);

        p1.name = "CC";//修改成功
        hashSet.remove(p1);//删除失败:修改成功后,调用remove()是以{id=1001, name='CC'}的哈希值查找,set中只存有{id=1001, name='AA'}的哈希值
        System.out.println(hashSet);

        hashSet.add(new Person1(1001,"CC"));
        System.out.println(hashSet);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='CC'}]

        //Person1调用equals();
        hashSet.add(new Person1(1001,"AA"));
        System.out.println(hashSet);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='AA'}]

    }

}
