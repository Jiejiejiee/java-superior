package com.superior.collection.list;

import com.other.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();

        System.out.println("请输入学生信息:");

        while (true){

            System.out.println("1:继续录入,0:结束录入");

            int step = sc.nextInt();

            if (step == 0){
                break;
            }

            System.out.print("请输入姓名:");
            String name = sc.next();
            System.out.println("请输入年龄:");
            int age = sc.nextInt();

            Student stu = new Student(name,age);

            list.add(stu);

        }

        sc.close();

//        System.out.println(list);
        for (Object s : list){
            System.out.println(s.toString());
        }

    }

}
