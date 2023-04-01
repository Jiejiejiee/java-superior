package com.superior.exceptionhandle.m_throws;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideDemo {
    /*

        自洽
                只针对于编译时异常

     */

    public static void main(String[] args) {

        father fu = new son();

        try {

            fu.method();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

class father{

    public void method() throws IOException {

        method();

    }

}

class son extends father{

    @Override
    public void method() throws FileNotFoundException {

    }

}
