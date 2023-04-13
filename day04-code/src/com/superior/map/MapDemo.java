package com.superior.map;

import org.junit.Test;

import java.util.*;

public class MapDemo {

    //Map中的实现类
    @Test
    public void test1(){

        Map map = new HashMap();

        map.put(null,null);
        map.put("Tom",23);
        map.put("CC",new Date());
        map.put(34,"AA");

        System.out.println(map);

    }

    @Test
    public void test2(){

        Map map = new Hashtable();

        map.put(null,"123");//NullPointerException
        map.put("AA",null);//NullPointerException

        System.out.println(map);

    }

    @Test
    public void test3(){

        LinkedHashMap map = new LinkedHashMap();

        map.put(null,null);
        map.put("Tom",23);
        map.put("CC",new Date());
        map.put(34,"AA");

        System.out.println(map);

    }

}
