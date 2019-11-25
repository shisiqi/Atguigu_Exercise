package com.atguigu.java2;

/**
 * 某公司面试题
 * 貌似考察值传递
 *
 */
public class ValueTransferTest3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //需要在method方法被调用后，打印出a=100,b=200
        //请写出method方法的代码
        method(a,b);
        System.out.println("a=" + a ) ;
        System.out.println("b=" + b ) ;
    }

    public static void  method(int a,int b){
        a = a*10;
        b = b*10;
        System.out.println("a=" + a ) ;
        System.out.println("b=" + b ) ;
        System.exit(0);//终止当前JVM的执行
    }
}
