package com.atguigu.jdbc;

import org.junit.Test;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTest {


    /**
     * Driver是一个接口：数据库厂商必须提供实现的接口，
     * 能从其中获取数据库连接
     *
     * 1.加入mysql驱动
     *      1)解压mysql-connector-java-5.1.7.zip压缩包
     *      2)在当前项目下新建lib目录
     *      3)把mysql-connector-java-5.1.7-bin.jar复制到lib目录下
     *      4)右键Mark Directory as Resources Root
     */
    @Test
    public void test1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "";
        Properties info = new Properties();
        driver.connect(url,info);
    }
}
