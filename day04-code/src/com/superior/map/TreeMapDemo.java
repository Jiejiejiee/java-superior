package com.superior.map;

import com.other.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    @Test
    public void test1(){

        TreeMap map = new TreeMap();

        map.put("CC",89);
        map.put("BB",56);
        map.put("JJ",78);
        map.put("MM",21);
        map.put("SS",34);

        Set entrySet = map.entrySet();
        //对key元素的指定的属性大小顺序进行排序;key的类型必须保持一致
        for (Object entry : entrySet){
            System.out.println(entry);
        }

    }

    @Test
    public void test2(){

        TreeMap map = new TreeMap();

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 18);
        User u3 = new User("Rose", 23);
        User u4 = new User("Jack", 48);
        User u5 = new User("Tony", 27);

        map.put(u1,78);
        map.put(u2,56);
        map.put(u3,64);
        map.put(u4,44);
        map.put(u5,93);

        Set entrySet = map.entrySet();
        for (Object entry : entrySet){
            System.out.println(entry);
        }

    }

    //定制排序
    @Test
    public void test3(){

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    //key
                    int value = u1.getName().compareTo(u2.getName());
                    if (value != 0){
                        return value;
                    }
                    return (u1.getAge() - u2.getAge());
                }
                throw new RuntimeException("类型不匹配");
            }
        };

        TreeMap map = new TreeMap(comparator);

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 18);
        User u3 = new User("Rose", 23);
        User u4 = new User("Jack", 48);
        User u5 = new User("Tony", 27);
        User u6 = new User("Tony", 29);

        map.put(u1,78);
        map.put(u2,56);
        map.put(u3,64);
        map.put(u4,44);
        map.put(u5,93);
        map.put(u6,75);

        Set entrySet = map.entrySet();
        for (Object entry : entrySet){
            System.out.println(entry);
        }

    }

}
