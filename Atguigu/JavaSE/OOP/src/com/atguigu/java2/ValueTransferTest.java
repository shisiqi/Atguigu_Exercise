package com.atguigu.java2;

/**
 * 关于变量的赋值
 *      如果变量是基本数据类型，此时赋值的是变量保存的数据值；
 *      如果变量是引用数据类型，此时赋值的是变量保存的数据的地址值
 */
public class ValueTransferTest {
    public static void main(String[] args) {

        //基本数据类型的赋值
        int m = 10;
        int n = m;
        System.out.println("m=" + m +",n="+ n);//m=10,n=10

        n = 20;
        System.out.println("m=" + m +",n="+ n);//m=10,n=20

        System.out.println("*************************************");

        //引用数据类型的赋值
        Order o1 = new Order();
        o1.orderId = 1001;
        Order o2 = o1;
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
        //o1.orderId = 1001,o2.orderId = 1001

        o2.orderId = 1002;
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
        //o1.orderId = 1002,o2.orderId = 1002
        //通过分析内存结构便能得到结论

    }
}
class Order{
    int orderId;
}
