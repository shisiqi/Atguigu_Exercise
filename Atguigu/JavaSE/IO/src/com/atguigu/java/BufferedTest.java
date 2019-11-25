package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.BufferedInputStream
 * 2.BufferedOutputputStream
 * 3.BufferedReader
 * 4.BufferedWriter
 *  作用：提升流的读写速度
 */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //创建文件对象
            File file = new File("a.jpg");
            File file1 = new File("c.jpg");
            //创建流对象
            //这里为了提升读写效率，使用处理流中的缓冲流
            //注意：缓冲流是不能直接作用在文件上的，必须包在节点流外边
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //进行读入和写出操作
            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1){
                bos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            //关闭外层流的时候可以自动把内层流关闭了
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *使用缓冲流实现文本文件的复制
     */

    @Test
    public void test2() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("newHello.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = fis.read(cbuf)) != -1){
//                fos.write(cbuf,0,len);
//            }
            //方式二：
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
