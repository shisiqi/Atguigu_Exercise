package com.atguigu.java2;

/**
 * 方法形参的传递机制：值传递
 * 1.形参：方法定义时，声明在小括号内部的参数
 * 2.实参：在方法调用时，实际传递给形参的数据
 *  如果参数是基本数据类型，此时，实参赋给形参的是实参真实存储的数据值
 */

public class ValueTransferTest1 {
    public static void main(String[] args) {

        int m = 10;
        int n = 20;
        System.out.println("m=" + m +",n="+ n);
        //交换两个变量的值的操作
//        int temp = m;
//        m = n;
//        n = temp;
        //我们把交换两个变量的值的操作封装到一个方法中
        //要调用类中非静态方法，需要先创建对象
        ValueTransferTest1 v1 = new ValueTransferTest1();
        v1.swap(m,n);
        //通过画内存图分析
        //对在栈内存中产生的变量进行交换值的操作，
        //不影响在main中变量的值
        System.out.println("m=" + m +",n="+ n);//m=10,n=20
    }

    public void swap(int m ,int n){
        int temp = m;
        m = n;
        n = temp;
    }
}
