package com.superior.generic;

import org.junit.Test;

import java.util.*;

public class GenericDemo1 {

    //泛型在集合中的使用
    @Test
    public void test1() {

        List list = new ArrayList();

        list.add(35);
        list.add(46);
        list.add(17);
        list.add(39);
        list.add(68);
        list.add(54);

        //问题1:类型不安全,add()的参数是Object类型,意味着任何类型对象都可以添加成功
        list.add("A");//ClassCastException

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());

            //问题2:需要使用强转,可能导致ClassCastException异常
            Integer integer = (Integer) iterator.next();
            int score = integer;//自动拆箱

            System.out.println(score);

        }

    }

    //泛型在迭代器中的使用
    @Test
    public void test2() {

        List<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(82);
        list.add(64);
        list.add(89);
        list.add(93);

        //编译报错,保证类型安全
//        list.add("A");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());

            //添加的数据都是Integer类型，避免了强转
            Integer integer = iterator.next();
            int score = integer;//自动拆箱

            System.out.println(score);
        }

    }

    //泛型在Map中的使用
    @Test
    public void test3() {

//        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

        //jdk7的新特性
        HashMap<String,Integer> hashMap = new HashMap<>();//类型推断

        hashMap.put("AA",12);
        hashMap.put("BB",56);

//        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        //先调用Map.Entry获取Entry，再用泛型声明类型
//        Set<Map.Entry<String,Integer>> entries = hashMap.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        //jdk10新特性
        var entries = hashMap.entrySet();
        var iterator = entries.iterator();


        while (iterator.hasNext()){

//            System.out.println(iterator.next());

            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key +"--->"+ value);

        }

    }



}
