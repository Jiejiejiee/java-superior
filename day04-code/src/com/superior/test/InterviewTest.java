package com.superior.test;

import org.junit.Test;

public class InterviewTest {

    @Test
    public void testFor(){

        String[] str = new String[]{"AA","BB","CC","DD"};

        //赋值操作1:数组内的元素全被修改
//        for (int i = 0;i < str.length;i++){
//
//            str[i] = "MM";
//
//        }

        //赋值操作2:修改失败
        //赋值操作其实是将str的地址值赋给s,通过修改s其实是新创建了一个对象
        for (String s : str){

            s = "MM";

        }


        for (String s : str){
            System.out.println(s);
        }

    }

}
