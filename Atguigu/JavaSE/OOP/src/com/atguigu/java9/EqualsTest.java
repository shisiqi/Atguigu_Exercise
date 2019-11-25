package com.atguigu.java9;

/**
 *  面试题：== 和 equals的区别
 *  一、回顾 == 的使用
 *  1.可以使用在基本数据类型变量和引用数据类型变量中
 *  2.如果比较的是基本数据类型变量，比较两个变量保存的数据是否相等（不一定类型要相同）
 *    如果比较的是引用数据类型变量，比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 *
 *  二、equals()方法的使用
 *  1.是一个方法，而非运算符
 *  2.适用于引用数据类型
 *  3.Object类中equals的定义：
 *  public boolean equals(Object obj) {
        return (this == obj);
    }
    说明：Object类中equals的定义和==是相同的

    4.像String，Date，File，包装类等都重写了Object类中的equals()方法。重写以后，
    比较的不是两个对象的地址是否相同，而是比较两个对象的"实体内容"是否相同。

    5。通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。
      那么需要对Object中的equals()进行重写

    重写原则：比较两个对象的"实体内容"是否相同
 */
public class EqualsTest {
    public static void main(String[] args) {

        //测试基本数据类型
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);//true
        System.out.println(i == d);//true

        boolean b = true;
        //System.out.println(i == b);编译失败
        char c = 10;
        System.out.println(i == c);//true


        //测试引用数据类型
        Customer customer = new Customer("tom",26);
        Customer customer1 = new Customer("tom",26);
        //比较的是两个对象的引用是否相同?new了两个对象，显然不是同一个对象实体，所以是false
        System.out.println(customer == customer1);//false

        String str1 = new String("atguigu");
        String str2 = new String("atguigu");
        System.out.println(str1 == str2);//false
        System.out.println("**********************************");
        System.out.println(customer.equals(customer1));// false
        // Customer重写了Object类中的equals方法后，输出为true
        System.out.println(str1.equals(str2));//true
    }
}
