package com.atguigu.java11;

/**对属性可以赋值的位置
 * 1.默认初始化
 * 2.显式初始化
 * 3.构造器
 * 4对象.属性或者对象.setXXX
 * 5.代码块
 *
 * 执行的先后顺序 1-->2/5-->3--?4
 *  若成员变量先声明则显式初始化先执行
 *  若代码块先声明则代码块先执行
 *
 *
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.orderId);//4
    }
}

class Order{
    int orderId = 3;//显式赋值
    {
        orderId = 4;
    }
}
