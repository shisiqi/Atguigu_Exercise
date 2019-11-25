package com.atguigu.java;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    /**
     * 将IO下的hello.txt文件中的内容读入内存，并输出到控制台
     * 1.read()返回读入的一个字符。如果达到文件末尾，返回-1
     * 2.将流资源的关闭放到finnally块中进行
     * 3.读入的文件一定要保证存在，否则会报FileNotFoundException
     */
    @Test
    public void test1(){
        FileReader reader = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //2.提供具体的流
            reader = new FileReader(file);
            //3.数据的读入
//        int data = reader.read();
//        while (data !=-1){
//            System.out.print((char) data);
//            data = reader.read();
//        }
            int data;
            while ((data = reader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if(reader != null)
                    reader.close();//为了保证流资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * read的操作升级，使用read的重载方法
     */
    @Test
    public void test2(){
        FileReader fr = null;
        try {
            //1.File类的实列化
            File file = new File("hello.txt");
            //2.流的实列化
            fr = new FileReader(file);
            //3.读入的操作
                //read(cbuf):返回每次读入cbuf数组的字符的个数
                //如果达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
//                for(int i=0;i<len;i++){
//                    System.out.print(cbuf[i]);
//                }
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    /**
     * 从内存中写出数据到硬盘文件里
     *  说明：
     *   1.输出操作，对应的File若不存在，输出过程中会自动帮我们创建该文件
     *   2.存在的话 两种构造器：
     *      1）new FileWriter(file,true) ---->对原有文件进行追加
     *      2）new FileWriter(file,false) ---->对原有文件进行覆盖
     */
    @Test
    public void test3() throws IOException {
        //1.创建File类的实例
        File file = new File("hello.txt");
        //2.创建输出流的实例
        FileWriter fw = new FileWriter(file,true);
        //3.写出操作
        fw.write("shisiqi\n");
        fw.write("akke\n");
        //4.关闭资源
        fw.close();
    }


    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建File类的对象，指明读入和写出的文件
            File inputFile = new File("hello.txt");
            File outPutFile = new File("hello1.txt");
            //2.创建输入流和输出流对象
            fr = new FileReader(inputFile);
            fw = new FileWriter(outPutFile);
            //3.数据的读入和写出操作
            //先进行数据的读入
            //定义一个数组，用于存储每次读入的内容
            char[] cbuf = new char[5];
            //定义一个长度用于记录每次读取到的字符个数
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
