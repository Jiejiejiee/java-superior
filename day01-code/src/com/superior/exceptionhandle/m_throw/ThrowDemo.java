package com.superior.exceptionhandle.m_throw;

public class ThrowDemo {
    /*

        程序在执行过程中,不满足指定情况下.我们主动使用"throw + 异常类的对象"抛出异常

     */

    public static void main(String[] args) {

//        Student stu = new Student();
//        stu.regist(-10);
//
//        System.out.println(stu);

//        try {
//            Student1 student1 = new Student1();
//            student1.register(10);
//
//            System.out.println(student1);
//        }catch (RuntimeException e){
//            System.out.println(e.getMessage());
//        }

        Student2 student2 = new Student2();
        try {

            student2.register(-10);

            System.out.println(student2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

class Student1{
    int id;

    public void register(int id){

        if (id > 0){
            this.id = id;
        }else {
            //System.out.println("数据非法");

            //运行时异常,异常可不处理
            //手动抛出异常类对象
            throw new RuntimeException("id数据非法");

        }

    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                '}';
    }
}

class Student2{
    int id;

    public void register(int id) throws Exception {

        if (id > 0){
            this.id = id;
        }else {
            //System.out.println("数据非法");

            //编译时异常,必须处理异常
            //手动抛出异常类对象
            throw new Exception("id数据非法");

        }

    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                '}';
    }
}