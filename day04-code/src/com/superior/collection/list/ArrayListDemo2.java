package com.superior.collection.list;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListDemo2 {

    public static void main(String[] args) {

        //随机生成30个字符,存放在ArrayList中
        ArrayList list = new ArrayList();

        for (int i = 0; i < 30; i++) {
            //'a'~'z' [97,122]:生成随机数,再强转为字符
            list.add((char) (Math.random() * (122 - 97 + 1) + 97) + "");//转成string类型
        }

        System.out.println(list);

        //遍历AL,查找元素出现的次数

        int aCount = listTest(list,"a");
        int bCount = listTest(list,"b");
        int cCount = listTest(list,"c");
        int xCount = listTest(list,"x");

        System.out.println("a:"+aCount);
        System.out.println("b:"+bCount);
        System.out.println("c:"+cCount);
        System.out.println("x:"+xCount);


    }

    public static int listTest(Collection list, String str){

        int count = 0;
        for (Object obj : list){

            if (str.equals(obj)) {
                count++;
            }

        }
        return count;

    }

}
