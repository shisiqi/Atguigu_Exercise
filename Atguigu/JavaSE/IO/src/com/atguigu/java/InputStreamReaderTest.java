package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 *  也属于字符流
 * 1.InputStreamReader：将一个字节的输入流转化为字符的输入流（解码）
 * 2.OutputStreamWriter：将一个字符的输出流转换为字节的输出流（编码）
 * 作用：提供字节流和字符流之间的转换
 * 字符集
 *
 */
public class InputStreamReaderTest {

    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        //参数2使用什么字符集取决于文件保存时使用的什么字符集
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        char[] cbuf = new char[10];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
        isr.close();
    }


    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //以utf-8读，以gbk写
            FileInputStream fis = new FileInputStream("hello.txt");
            FileOutputStream fos = new FileOutputStream("gbk.txt");
            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");
            char[] cbuf = new char[10];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null)
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
