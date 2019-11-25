package com.atguigu.java3;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    //Properties：常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc.properties"));
        String user = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(user +":"+ password);
    }
}
