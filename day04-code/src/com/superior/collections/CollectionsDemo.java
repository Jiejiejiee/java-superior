package com.superior.collections;

import org.junit.Test;

import java.util.*;

/*

    Collections是一个操作 Set、List和Map等集合的工具类

        Collection:集合框架中用于存储一个一个元素的接口,又分为List和Set等子接口

 */
public class CollectionsDemo {

    @Test
    public void test1(){

        List list = Arrays.asList(45, 23, 6, 5, 4, 851, 64, 561, 654, 84, 61, 65, 49, 45);

        System.out.println(list);

        //reverse(List);反转List中的元素
//        Collections.reverse(list);

        //shuffle(List);对List集合元素进行随机排列
//        Collections.shuffle(list);

        //sort(List);根据元素的自然顺序对指定的List集合元素按升序排序
//        Collections.sort(list);

        //sort(List,Comparator);根据指定的Comparator产生的顺序对List中的元素进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;

                    return -(i1.intValue() - i2.intValue());

                }
                throw new RuntimeException("类型不匹配");
            }
        });

        //swap(List,int,int);将指定索引位置的元素位置交换

        System.out.println(list);


    }

    @Test
    public void test2(){

        List list = Arrays.asList(45, 23, 6, 5, 4, 851, 64, 561, 654, 84, 61, 65, 49, 45);
        System.out.println(list);

        Object max = Collections.max(list);
        System.out.println(max);


        Object max1 = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;

                    return -(i1.intValue() - i2.intValue());

                }
                throw new RuntimeException("类型不匹配");
            }
        });
        //降序排列,输出最后面的元素
        System.out.println(max1);

        System.out.println(Collections.frequency(list, 45));

    }

    @Test
    public void test3(){

        List src = Arrays.asList(45, 23, 6, 5, 45, 851, 64, 561, 654, 84, 61, 65, 49, 45);

        //void copy(List dest,List src);将src中的内容复制到dest中

        //错误写法
//        ArrayList dest = new ArrayList();
//        Collections.copy(dest,src);//IndexOutOfBoundsException: Source does not fit in dest

        List dest = Arrays.asList(new Object[src.size()]);
        Collections.copy(dest,src);

        System.out.println(dest);

    }

    //提供多个unmodifiableXxx()方法,该方法返回指定Xxx的不可被修改的试图
    @Test
    public void test4(){

        List list1 = new ArrayList();

        //list1可以写入数据
        list1.add(34);
        list1.add(12);
        list1.add(478);

        List list2 = Collections.unmodifiableList(list1);
        //此时的list2只可读,不可写

//        list2.add(25);//UnsupportedOperationException

        System.out.println(list2);

    }

    //synchronizedXxx()
    @Test
    public void test5(){

        List list1 = new ArrayList();

        //返回的list2就是线程安全的
        List list2 = Collections.synchronizedList(list1);

        HashMap map1 = new HashMap();
        //返回的map2就是线程安全的
        Map map2 = Collections.synchronizedMap(map1);

    }

}
