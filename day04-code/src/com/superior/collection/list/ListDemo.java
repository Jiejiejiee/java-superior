package com.superior.collection.list;

import com.other.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*

    List:用于存储有序的,可重复的数组 ---> 使用List代替数组,"动态"数组

    List除了从Collection集合继承的方法外，List 集合里添加了一些`根据索引`来操作集合元素的方法。
    - 插入元素
        - `void add(int index, Object ele)`:在index位置插入ele元素
        - boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    - 获取元素
        - `Object get(int index)`:获取指定index位置的元素
        - List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
    - 获取元素索引
        - int indexOf(Object obj):返回obj在集合中首次出现的位置
        - int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    - 删除和替换元素
        - `Object remove(int index)`:移除指定index位置的元素，并返回此元素
        - `Object set(int index, Object ele)`:设置指定index位置的元素为ele

 */
public class ListDemo {

    /**增&插
     * add(int index,object eles);
     * addAll(int index,collection eles);
     */
    @Test
    public void test1(){

        List list = new ArrayList();

        list.add("AA");
//        list.add("BB");
        list.add("CC");
        list.add(123);

        Person p = new Person("Tom",18);
        list.add(p);

        System.out.println(list);

        list.add(1,"BB");
        System.out.println(list);

        Collection collection = new ArrayList();

        collection.add("DD");
        collection.add("EE");

        list.addAll(3,collection);
        System.out.println(list);

    }

    /**删
     * remove()
     */
    @Test
    public void test2(){

        List list = new ArrayList();

        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add(2);
        list.add(123);

        Person p = new Person("Tom",18);
        list.add(p);

        list.remove(2);//索引
        System.out.println(list);

        list.remove(Integer.valueOf(2));//对象
        System.out.println(list);

    }

    /**遍历
     *
     */
    @Test
    public void test3(){

        List list = new ArrayList();

        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add(2);
        list.add(123);

        Person p = new Person("Tom",18);
        list.add(p);

        //遍历方式1:迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("**********");

        //遍历方式2:foreach
        for (Object obj : list){
            System.out.println(obj);
        }

        System.out.println("**********");

        //遍历方式3:for循环
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }

    }

}
