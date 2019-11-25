package com.atguigu.java;

import org.junit.Test;

import java.io.*;

public class FileInputOutputStreamTest {

    /**
     * 使用字节流完成图片的复制
     *
     */
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建图片文件对象
            File file = new File("a.jpg");
            File outPutFile = new File("b.jpg");
            //创建字节流对象
            fis = new FileInputStream(file);
            fos = new FileOutputStream(outPutFile);
            //读取，写出
            byte[] bbuf = new byte[5];
            int len;
            while ((len = fis.read(bbuf)) != -1){
                fos.write(bbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
