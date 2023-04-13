package com.superior.map;

import com.other.Person;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class HashMapDemo {

    @Test
    public void test1() {

        HashMap map = new HashMap();

        //put(Object key,Object value)
        map.put("AA", 56);
        map.put(67, "Ton");
        map.put("BB", 89);
        map.put(new Person("Jerry", 18), 56);

        System.out.println(map);
        //size()
        System.out.println(map.size());

        //Object remove(Object key)
        Object value = map.remove("AA");
        System.out.println(map);
        System.out.println(value);

        //修改:Object put(Object key,Object value)
        Object oldValue = map.put("BB", 90);
        System.out.println(map);
        System.out.println(oldValue);

        //get(Object key)
        Object jerryValue = map.get(new Person("Jerry", 18));
        System.out.println(jerryValue);

    }

    //遍历key集:Set keySet();
    @Test
    public void test2() {

        HashMap map = new HashMap();

        map.put("AA", 56);
        map.put(67, "Ton");
        map.put("BB", 89);
        map.put(new Person("Jerry", 18), 56);

        Set keySet = map.keySet();
        //使用迭代器遍历Set
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
//            System.out.println(keyIterator.next());
            Object key = iterator.next();
            System.out.println(key);
        }

    }

    //遍历value集:Collection values();
    @Test
    public void test3() {

        HashMap map = new HashMap();

        map.put("AA", 56);
        map.put(67, "Ton");
        map.put("BB", 89);
        map.put(new Person("Jerry", 18), 56);

        //方式1
        Collection values = map.values();
        //遍历Collection
        for (Object obj : values) {
            System.out.println(obj);
        }

        System.out.println("--------------------");

        //方式2:
        Set keySet = map.keySet();

        for (Object key : keySet) {
            Object value = map.get(key);
            System.out.println(value);
        }

    }

    //遍历entry集:Set entrySet();
    @Test
    public void test4() {

        HashMap map = new HashMap();

        map.put("AA", 56);
        map.put(67, "Ton");
        map.put("BB", 89);
        map.put(new Person("Jerry", 18), 56);

        //方式1:
        Set entrySet = map.entrySet();

        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            //方式①:
//            System.out.println(iterator.next());
//            Object obj = iterator.next();
//            System.out.println(entity);

            //方式②:
            Map.Entry entity = (Map.Entry) iterator.next();

            System.out.println(entity.getKey() + "--->" + entity.getValue());

        }

        System.out.println("-------------------------");

        //方式2:
        Set keySet = map.keySet();
        for (Object key : keySet) {

            System.out.println(key + "--->" + map.get(key));

        }

    }

}
