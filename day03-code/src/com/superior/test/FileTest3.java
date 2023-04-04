package com.superior.test;

import org.junit.Test;

import java.io.File;

public class FileTest3 {

    public static void main(String[] args) {

        File file = new File("D:\\Workspace\\Idea");

        printFileName(file);

    }

    @Test
    public static void printFileName(File file) {

        if (file.isFile()) {

            System.out.println(file.getName());

        } else if (file.isDirectory()) {

            File[] files = file.listFiles();

            for (File f : files) {

                printFileName(f);

            }
        }

    }

}
