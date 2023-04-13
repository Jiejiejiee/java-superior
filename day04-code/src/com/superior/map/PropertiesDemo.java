package com.superior.map;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*

    Properties是Hashtable的子类,其key和value都是String类型,常用来处理属性文件
        例如:配置文件
 */
public class PropertiesDemo {

    //数据与代码耦合度高;如果修改数据需要重新编译代码,打包发布
//    @Test
//    public void test(){
//
//        //数据
//        String name = "Tom";
//        String password = "abc123";
//
//        //代码:用于操作name,password
//        //...
//
//    }

    //将数据封装到具体的配置文件,在程序中读取配置文件的信息;实现类数据与代码的解耦
    @Test
    public void test() throws IOException {

        File file = new File("info.properties");
//        System.out.println(file.getAbsolutePath());

        FileInputStream fis = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fis);//加载流中的文件中的数据

        //读取数据
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name + ":" + password);

        fis.close();

    }

}
