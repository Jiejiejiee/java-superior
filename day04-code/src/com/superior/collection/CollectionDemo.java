package com.superior.collection;

import com.other.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionDemo {

    /**添加元素
     * add(E obj)：添加元素对象到当前集合中
     * addAll(Collection other)：添加other集合中的所有元素对象到当前集合中，即this = this ∪ other
     *          add也可以将另一个集合添加到该集合中,前者是将所有元素依次加入,后者则是将该集合作为一个整体加入
     */
    @Test
    public void test1(){

        Collection collection1 = new ArrayList();

        collection1.add("AA");
        collection1.add(123);//自动装箱
        collection1.add("嘀嘀嘀");
        collection1.add(new Object());
        collection1.add(new Person("tom",18));

        System.out.println(collection1);

        Collection collection2 = new ArrayList();

        collection2.add("BB");
        collection2.add(456);

        collection2.addAll(collection1);

        System.out.println(collection2);

        System.out.println(collection1.size());
        System.out.println(collection2.size());


    }

    /**判断
     *int size()：获取当前集合中实际存储的元素个数
     *boolean isEmpty()：判断当前集合是否为空集合
     *boolean contains(Object obj)：判断当前集合中是否存在一个与obj对象equals返回true的元素
     *boolean containsAll(Collection coll)：判断coll集合中的元素是否在当前集合中都存在。即coll集合是否是当前集合的“子集”
     *boolean equals(Object obj)：判断当前集合与obj是否相等
     */
    @Test
    public void test2(){

        Collection collection1 = new ArrayList();
        Collection collection2 = new ArrayList();

        collection1.add("AA");
        collection1.add(123);
        collection1.add("嘀嘀嘀");
        collection1.add(new Person("tom",18));

        System.out.println(collection1.isEmpty());//判断size()==0
        System.out.println(collection2.isEmpty());

        System.out.println(collection1.contains("AA"));
        System.out.println(collection1.contains(3));
        //直接比较对象需要在类中重写equals();
        System.out.println(collection1.contains(new Person("tom",18)));//false ---> true

        collection2.add("AA");
//        collection2.add("BB");
        collection2.add(123);

        System.out.println(collection1.containsAll(collection2));//false ---> true

        System.out.println(collection1.equals(collection2));//false

    }

    /**删除
     *void clear()：清空集合元素
     *boolean remove(Object obj) ：从当前集合中删除第一个找到的与obj对象equals返回true的元素。
     *boolean removeAll(Collection coll)：从当前集合中删除所有与coll集合中相同的元素。即this = this - this ∩ coll
     *boolean retainAll(Collection coll)：从当前集合中删除两个集合中不同的元素，使得当前集合仅保留与coll集合中的元素相同的元素，即当前集合中仅保留两个集合的交集，即this  = this ∩ coll；
     */
    @Test
    public void test3(){

        Collection collection = new ArrayList();
        Person p1 = new Person("tom",18);

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(p1);

        collection.clear();
        System.out.println(collection.isEmpty());//true
        System.out.println(collection.size());//0

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(new Person("tom",18));

        collection.remove(123);
        System.out.println(collection);
        System.out.println(collection.remove(new Person("tom", 18)));//true;在类中重写过equals()
        System.out.println(collection);

        Collection collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        collection1.add(4);
        collection1.add(5);

        Collection collection2 = new ArrayList();
        collection2.add(3);
        collection2.add(4);
        collection2.add(5);
        collection2.add(6);
        collection2.add(7);

//        collection1.removeAll(collection2);
//        System.out.println(collection1);//[1, 2]

        collection1.retainAll(collection2);
        System.out.println(collection1);//[3, 4, 5]


    }

    /**其他
     *Object[] toArray()：返回包含当前集合中所有元素的数组
     *hashCode()：获取集合对象的哈希值
     *iterator()：返回迭代器对象，用于集合遍历
     */
    @Test
    public void test4(){

        Collection collection = new ArrayList();
        Person p1 = new Person("tom",18);

        collection.add("AA");
        collection.add(123);
        collection.add("嘀嘀嘀");
        collection.add(p1);

        //集合转化为数组
        Object[] arr = collection.toArray();
        System.out.println(Arrays.toString(arr));

        //hashCode();
        System.out.println(collection.hashCode());//744292317

        //TODO:iterator();


    }

    /**
     * 集合 ---> 数组
     * 数组 ---> 集合
     */
    @Test
    public void test5(){

        String[] arr= new String[]{"AA","BB","CC"};
        List<String> strings = Arrays.asList(arr);

        System.out.println(strings);

        Integer[] arr1 = new Integer[]{1,2,3};//包装类,3个对象
        List list1 = Arrays.asList(arr1);
        System.out.println(list1.size());//3

        int[] arr2 = new int[]{1, 2, 3};//基本数据类型,一个对象
        List list2 = Arrays.asList(arr2);
        System.out.println(list2.size());//1

    }

}
