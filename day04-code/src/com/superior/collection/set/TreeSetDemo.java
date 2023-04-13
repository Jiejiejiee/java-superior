package com.superior.collection.set;

import com.other.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*

    TreeSet:底层使用红黑树存储,可以按照添加的元素的指定的属性大小顺序进行遍历

 */
public class TreeSetDemo {

    @Test
    public void test1() {

        TreeSet treeSet = new TreeSet();

        treeSet.add("CC");
        treeSet.add("AA");
        treeSet.add("DD");
        treeSet.add("MM");
        treeSet.add("GG");
        treeSet.add("SS");

        //TreeSet添加元素时,会比较元素的类型,否则无法排序
//        treeSet.add(123);//ClassCastException

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());//String类自然排序
        }

    }

    /**
     * 判断数据是否相同的标准
     * 不再是考虑hashCode()和equals()方法了,也就意味着添加到TreeSet中的元素所在的类不需要重写hashCode()和equals()方法
     * 比较元素的大小或是比较元素是否相等的标准就是考虑自然排序或定制排序中,compareTo()或compare()的返回值
     * 如果compareTo()或compare()的返回值为0,则认为两个对象是相等的,后者不再放入set中
     *
     *
     */
    @Test
    public void test2() {

        TreeSet treeSet = new TreeSet();

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 18);
        User u3 = new User("Rose", 23);
        User u4 = new User("Jack", 48);
        User u5 = new User("Tony", 27);

        treeSet.add(u1);
        treeSet.add(u2);
        treeSet.add(u3);
        treeSet.add(u4);
        treeSet.add(u5);

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());//String类天生具有排序
        }

    }

    /**定制排序
     * 添加到TreeSet中的元素必须考虑排序,自然排序/定制排序
     */
    @Test
    public void rest3() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    int value = u1.getAge() - u2.getAge();
                    if (value != 0) {
                        return value;
                    }
                    return u1.getName().compareTo(u2.getName());

                }
                throw new RuntimeException("类型不匹配");
            }
        };

        TreeSet treeSet = new TreeSet(comparator);

        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 18);
        User u3 = new User("Rose", 23);
        User u4 = new User("Jack", 48);
        User u5 = new User("Tony", 27);

        treeSet.add(u1);
        treeSet.add(u2);
        treeSet.add(u3);
        treeSet.add(u4);
        treeSet.add(u5);

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
