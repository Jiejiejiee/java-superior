package com.superior.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class GenericsTest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            int random = (int) (Math.random() * (99 - 0 + 1));
            list.add(random);

        }

        for (Integer value : list){
            System.out.println(value);
        }

        System.out.println("--------------------------");

        //使用集合的removeIf()删除偶数,为Predicate接口指定泛型
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0;
            }
        });

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
