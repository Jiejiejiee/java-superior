package com.superior.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest1 {

    public static void main(String[] args) {



    }

    @Test
    public void test1() {

        //此路径为绝对路径
        File file1 = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\resources\\file\\hello.txt");

        File file2 = new File(file1.getParent(),"abc.txt");
        try {
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){

        //此路径为相对路径
        File file1 = new File("hellow.txt");

//        System.out.println(file1.exists());
        System.out.println(file1.getAbsoluteFile().getParent());

        //获取file1的绝对路径,获取此路径的上层文件目录
        File file2 = new File(file1.getAbsoluteFile().getParent(),"abc.txt");

        try {
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
