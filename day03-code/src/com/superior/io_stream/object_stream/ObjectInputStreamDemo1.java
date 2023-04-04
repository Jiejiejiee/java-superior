package com.superior.io_stream.object_stream;

import org.junit.Test;

import java.io.*;

public class ObjectInputStreamDemo1 {

    @Test
    public void test() throws IOException, ClassNotFoundException {

        File file = new File("object.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        //读取文件中的对象(即为反序列化过程)
        String str1 = ois.readUTF();
        System.out.println(str1);

        String str2 = (String) ois.readObject();
        System.out.println(str2);

        ois.close();
    }

}
