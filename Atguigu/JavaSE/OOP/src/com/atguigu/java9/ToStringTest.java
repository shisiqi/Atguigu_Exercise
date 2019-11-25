package com.atguigu.java9;

import java.util.Date;

/**
 * Object类中toString的使用
 * 1.当我们去输出一个对象的引用时，实际上就是去调用当前对象的toString方法
 * 2.Object中toString方法的定义：
 *      public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
 * 3.像Date，String，File和包装类都重写了Obejct类中的toString方法。
 *   使得在调用对象的toString方法时，返回"实体内容"
 *
 */
public class ToStringTest {
    public static void main(String[] args) {
        Customer customer = new Customer("shisiqi",26);
        //未重写toString方法之前
        System.out.println(customer.toString());//com.atguigu.java9.Customer@28d93b30
        System.out.println(customer);//com.atguigu.java9.Customer@28d93b30

        String str = new String("shisiqi");
        //为什么这里能直接输出字符串的值，而不是类名@哈希值？
        //因为String类重写了Object的toString方法
        System.out.println(str);//shisiqi
        Date date = new Date();
        System.out.println(date);//Sat Jul 27 16:34:23 CST 2019

        //重写了toString方法之后
        System.out.println(customer);//Customer{name='shisiqi', age=26}

    }
}
