package com.atguigu.java9;

import org.junit.Test;

/**
 * 包装类的使用
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量有类的特征
 * 2.需要熟练掌握的：基本数据类型、包装类和String的互相转换
 *
 *
 *
 */
public class WrapperTest {


    //基本数据类型--->包装类：调用包装类的构造器
    @Test
    public void test1(){
        int num1 = 10;
        Integer integer1 = new Integer(num1);
        System.out.println(integer1);//10

        Integer integer2 = new Integer("123");
        System.out.println(integer2);//123

        //Integer integer3 = new Integer("123abc");//必须是纯数字
        //System.out.println(integer3);//java.lang.NumberFormatException: For input string: "123abc"

        Float float1 = new Float(12.3f);
        System.out.println(float1);//12.3
    }

    //包装类--->基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2(){
        Integer integer1 = new Integer(12);
        int i = integer1.intValue();
        System.out.println(i);//12

        Float float1 = new Float(12.3);
        float value = float1.floatValue();
        System.out.println(value);//12.3
    }
    /*
    jdk5.0新特性：自动装箱与拆箱
     */
    @Test
    public  void test3(){
        //自动装箱
        //使用自动装箱能把int类型的数据转换为Integer包装类（不使用Integer的构造器）
        Integer i = 3;
        System.out.println(i);//3
        Double d1 = 2.333;
        System.out.println(d1);//2.333


        //自动拆箱
        int i1 = i;//把包装类对象直接赋给基本数据类型
    }

    /*
      基本数据类型、包装类---->String
        调用String重载的方法valueOf(xxxx)
     */
    @Test
    public void test4(){
        int num1 = 10;
        //方式一：连接运算，拼接一个空字符串
        String str1 = num1 + "";
        System.out.println(str1);//"10"
        //方式二：调用String的valueOf方法
        double d1 = 3.5;
        String str2 = String.valueOf(d1);
        System.out.println(str2);//"3.5"
        Integer i = 3;
        String str3 = String.valueOf(i);
        System.out.println(str3);//"3"
    }

    //String类型--->基本数据类型、包装类:调用包装类的parseXXX方法
    @Test
    public void test5(){
        String str1 = "123";
        Integer i = Integer.parseInt(str1);
        System.out.println(i);//123

        String str2 = "TRUE";
        String str3 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        boolean b2 = Boolean.parseBoolean(str3);
        System.out.println(b1);//true
        System.out.println(b2);//false

    }
}
