package com.superior.file;

import org.junit.Test;

import java.io.File;

public class FileDemo1 {
    /*

     `public File(String pathname)：以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
     `public File(String parent, String child)：以parent为父路径，child为子路径创建File对象。
     `public File(File parent, String child)：根据一个父File对象和子文件路径创建File对象

     */

    public static void main(String[] args) {

//        File file2 = new File("abc");
//
//        System.out.println(file2.getAbsolutePath());//D:\Workspace\Idea\Java-Learning\Superior\abc

    }

    @Test
    public void test1(){
        //`public File(String pathname)：以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
        /*

            文件的路径表示方式：

                    绝对路径:包括盘符在内的文件或文件目录的完整路径

                    相对路径:相对于某一个文件目录来讲的相对的位置
                        在idea中,如果使用单元测试方法:相对于当前的module来讲
                                如果使用main()方法:相对于当前的project来讲

         */

        //创建的是内存数据上的一个对象,由这个内存对象指向该文件,所以该文件是否存在该对象都不报错
        File file1 = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\src\\com\\superior\\file\\hello.txt");

        File file2 = new File("abc");
        System.out.println(file2.getAbsolutePath());

    }

    @Test
    public void test2(){

        //`public File(String parent, String child)：以parent为父路径，child为子路径创建File对象。
        //参数1:一定是一个文件目录
        //参数2:可以是一个文件,也可以是一个目录
        File file1 = new File("D:\\io","hello.txt");
        File file2 = new File("abc","abc.txt");

    }

    public void test3(){

        //`public File(File parent, String child)：根据一个父File对象和子文件路径创建File对象
        File file1 = new File("abc","efg");
        //参数1:一定是一个文件目录
        //参数2:可以是一个文件,也可以是一个目录
        File file2 = new File(file1,"abc.txt");

    }

}
