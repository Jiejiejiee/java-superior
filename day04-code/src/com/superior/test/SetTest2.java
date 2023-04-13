package com.superior.test;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest2 {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();

        while (hashSet.size() < 10) {//避免随机数相同导致数字不够
            int random = (int) (Math.random() * (10 - 1 + 1) + 1);
            hashSet.add(random);
        }

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
