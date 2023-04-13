package com.superior.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SetTest1 {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add(34);
        list.add(17);
        list.add(53);
        list.add(22);
        list.add(21);
        list.add(34);
        list.add(45);
        list.add(45);
        list.add(22);
        list.add(78);
        list.add(65);
        list.add(21);
        list.add(45);

        List newList = duplicateList(list);

        Iterator iterator = newList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static List duplicateList(List list){

        //方式1:
//        HashSet hashSet = new HashSet();
//        for (Object obj : list){
//            hashSet.add(obj);
//        }
//
//        List arrayList = new ArrayList();
//        for (Object obj : hashSet){
//            arrayList.add(obj);
//        }
//
//        return arrayList;

        //方式2:
        HashSet hashSet = new HashSet(list);
        List arrayList = new ArrayList(hashSet);
        return arrayList;

    }

}
