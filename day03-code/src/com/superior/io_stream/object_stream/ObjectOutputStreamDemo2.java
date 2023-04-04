package com.superior.io_stream.object_stream;

import org.junit.Test;

import java.io.*;

/*

    NotSerializableException:不能序列化异常

    自定义类要想实现序列化机制,需要满足:

            1.实现接口Serializable.(只是一个表示,不需要重写任何方法)
            2.要求自定义类声明一个全局常量(用来唯一标识当前的类)

                如果不声明全局常量serialVersionUID,系统会自动声明一个针对与当前类的serialVersionUID
                如果修改此类的话,会导致serialVersionUID变化,进而导致反序列化时出现异常

            3.要求自定义类的各个属性也必须时可序列化的

                基本数据类型:默认就是可以序列化的
                引用数据类型:要求实现Serializable接口

            4.类中静态的属性不进行序列化,且若要类中可序列的属性不序列化,使用transient修饰

 */
public class ObjectOutputStreamDemo2 {

    //序列化过程:
    @Test
    public void test() throws IOException {

        File file = new File("person_object.bat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        Persion p1 = new Persion("Tom",12);
        oos.writeObject(p1);
        oos.flush();

        Persion p2 = new Persion("Jerry",23,1001,new Account(2000));
        oos.writeObject(p2);
        oos.flush();

        oos.close();

    }

}
