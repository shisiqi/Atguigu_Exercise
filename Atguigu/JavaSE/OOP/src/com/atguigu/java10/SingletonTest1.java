package com.atguigu.java10;

/**
 * 单例设计模式：
 * 1.定义：采取一定的方法保证在整个软件系统中，对某个类只能存在一个实例
 * 2.如何实现：
 *      1）饿汉式
 *      2）懒汉式
 * 3.区分饿汉式和懒汉式
 *      饿汉式：坏处：对象加载时间过长
 *             好处：线程安全的
 *      懒汉式：好处：延迟对象的创建
 *             目前的写法坏处：线程不安全的--->到多线程内容时再修改
 *
 *
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
        System.out.println(instance1 == instance2);//true,两个对象的地址值相同，所以是同一个对象
    }
}

/*
饿汉式
 */
class Bank{
    //1.私有化构造器
    //不让别人在类外通过构造器的方式创建多个对象
    private Bank(){}
    //2.内部创建类的对象
    //4.要求此对象必须也声明为静态的
    private static Bank instance = new Bank();
    //3，提供公共的方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
