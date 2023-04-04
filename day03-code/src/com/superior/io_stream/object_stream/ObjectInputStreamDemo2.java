package com.superior.io_stream.object_stream;

import org.junit.Test;

import java.io.*;

public class ObjectInputStreamDemo2 {

    //反序列化过程
    @Test
    public void test() throws IOException, ClassNotFoundException {

        File file = new File("person_object.bat");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Persion persion1 = (Persion) ois.readObject();
        System.out.println(persion1);

        Persion persion2 = (Persion) ois.readObject();
        System.out.println(persion2);

        ois.close();

    }
}
