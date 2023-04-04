package com.superior.test;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest2 {

    //法一
    @Test
    public void test1() {

        File file1 = new File("hellow.txt");
        File dir = new File(file1.getAbsoluteFile().getParent());

        String[] list = dir.list();

        for (String s : list) {

//            System.out.println(s);

//            if (s.contains("llo")){
//                System.out.println(s);
//            }

            if (s.endsWith("txt")) {
                System.out.println(s);
            }

        }

    }

    //法二
    @Test
    public void test2() {

        File file1 = new File("hellow.txt");
        File dir = new File(file1.getAbsoluteFile().getParent());

        String[] listFiles = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {//name:为子文件或子文件名称

//                if (name.endsWith("txt")){
//                    System.out.println(name);
//                    return true;
//                }
//                return false;

                return name.endsWith("txt");

            }
        });

        for (String s : listFiles){
            System.out.println(s);
        }


    }

}
