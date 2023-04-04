package com.superior.io_stream.object_stream;

import org.junit.Test;

import java.io.*;

public class ObjectOutputStreamDemo1 {

    @Test
    public void test() throws IOException {

        //1.创建对象
        File file = new File("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //2.写出数据(即为序列化过程)
        oos.writeUTF("嘀嘀嘀");
        oos.flush();

        oos.writeObject("轻轻的我走了,正如我轻轻的来.");
        oos.flush();

        oos.close();

    }

}
