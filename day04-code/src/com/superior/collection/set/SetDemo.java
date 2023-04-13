package com.superior.collection.set;

import com.other.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*

    较List,map来说,Set使用的频率较小

        用来过滤重复数据

    无序性 != 随机性
          != 添加元素的顺序和遍历元素的顺序不一致
          = 添加元素的位置有关,不想ArrayList一样是依次紧密排列的,这里是根据添加元素的哈希值,计算其在数组中的存储位置
                    此位置不是依次排列的,表现为无序性

    不可重复性:添加到set中的元素是不能相等的

        比较的标准,需要判断hashCode()得到的哈希值与equals()得到的结果


 */
public class SetDemo {

    @Test
    public void test1(){

        Set set = new HashSet();

        set.add("AA");
        set.add(123);
        set.add("BB");
        Person p = new Person("Tom",23);
        set.add(p);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(set.contains(new Person("Tom", 23)));

    }

}
