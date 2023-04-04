package com.superior.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    /*

     * public String getName() ：获取名称
     * public String getPath() ：获取路径
     * public String getAbsolutePath()：获取绝对路径
     * public File getAbsoluteFile()：获取绝对路径表示的文件
     * public String getParent()：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值

     */

    @Test
    public void test1() {

        File file1 = new File("hello.txt");

        System.out.println(file1.getName());//hello.txt
        System.out.println(file1.getPath());//hello.txt
        System.out.println(file1.getAbsolutePath());//D:\Workspace\Idea\Java-Learning\Superior\day03-code\hello.txt
        System.out.println(file1.getAbsoluteFile());//D:\Workspace\Idea\Java-Learning\Superior\day03-code\hello.txt
        System.out.println(file1.getParent());//null
        System.out.println(file1.length());//0
        System.out.println(file1.lastModified());//0

        System.out.println(file1.getAbsoluteFile().getParent());

    }

    @Test
    public void test2() {

        File file1 = new File("D:\\Workspace\\Idea");

        System.out.println(file1.getName());//Idea
        System.out.println(file1.getPath());//D:\Workspace\Idea
        System.out.println(file1.getAbsolutePath());//D:\Workspace\Idea
        System.out.println(file1.getAbsoluteFile());//D:\Workspace\Idea
        System.out.println(file1.getParent());//D:\Workspace
//        System.out.println(file1.length());//文件目录的大小不能直接计算,需要累加
        System.out.println(file1.lastModified());//1679568364108

        System.out.println(file1.getAbsoluteFile().getParent());//D:\Workspace

    }

    /*

    列出目录的下一级
        public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

     */

    @Test
    public void test3() {

        File file1 = new File("D:\\Workspace\\Idea");

        String[] fileArr = file1.list();
        for (String s : fileArr) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file1.listFiles();
        for (File f : files
             ) {
            System.out.println(f);
//            System.out.println(f.getName());
        }

    }

    /*

    File重命名
    public boolean renameTo(File dest):把文件重命名为指定的文件路径。

    file1.renameTo(file2)
        file必须存在,file2必须不存在

     */

    @Test
    public void test4(){

        File file = new File("hellow.txt");

        boolean renameSuccess = file.renameTo(new File("hello.txt"));
        System.out.println(renameSuccess);

    }

    /*

    判断功能方法:
    - `public boolean exists()` ：此File表示的文件或目录是否实际存在。
    - `public boolean isDirectory()` ：此File表示的是否为目录。
    - `public boolean isFile()` ：此File表示的是否为文件。
    - public boolean canRead() ：判断是否可读
    - public boolean canWrite() ：判断是否可写
    - public boolean isHidden() ：判断是否隐藏

    若文件不存在,则全为false

     */

    @Test
    public void test5(){

        File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\resources\\hellow.txt");

        System.out.println(file.exists());//true
        System.out.println(file.isDirectory());//false
        System.out.println(file.isFile());//true
        System.out.println(file.canRead());//true
        System.out.println(file.canWrite());//true
        System.out.println(file.isHidden());//false


    }

    /*

    创建和删除
    - `public boolean createNewFile()` ：创建文件。若文件存在，则不创建，返回false。
    - `public boolean mkdir()` ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    - `public boolean mkdirs()` ：创建文件目录。如果上层文件目录不存在，一并创建。
    - `public boolean delete()` ：删除文件或者文件夹

    删除注意事项：① Java中的删除不走回收站。② 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录。

     */

    @Test
    public void test6() throws IOException {

        File file1 = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\resources\\file\\hello.txt");

        //System.out.println(file1.exists());
        if (!file1.exists()){

            boolean isSuccess = file1.createNewFile();

            if(isSuccess){
                System.out.println("创建成功");
            }

        }else {
            System.out.println("文件已存在");

            System.out.println( file1.delete() ? "文件已删除":"文件删除失败");
        }

    }

    @Test
    public void test7(){

        //前提:创建目录不存在,其父目录存在
        File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\resources\\image");

        System.out.println(file.mkdir());
//        file.mkdirs();

    }

    @Test
    public void test9(){

        File file = new File("D:\\Workspace\\Idea\\Java-Learning\\Superior\\day03-code\\resources\\image");

        System.out.println(file.delete());

    }


}
