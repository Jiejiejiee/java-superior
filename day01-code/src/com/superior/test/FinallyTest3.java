package com.superior.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest3 {

    public static void main(String[] args) {

        test();

    }

    public static void test() {

        FileInputStream fis = null;
        try {

            File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day01-code\\src\\com\\superior\\throwable\\hello.txt");

            fis = new FileInputStream(file);
            int data = fis.read();

            while (data != -1) {

                System.out.print((char) data);
                data = fis.read();

            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fis != null)
                    fis.close();//close本身也可能报一个异常

                System.out.println("close关闭");

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}
