package com.atguigu.java2;

/**
 *  输入一个数据n，计算斐波那契数列的第n个值
 *  1 1 2 3 5 8 13 21 34 55
 *  要求计算斐波那契数列的第n个值并将整个数列打印出来
 *
 */
public class FibonacciTest {
    public static void main(String[] args) {
        System.out.println(getFibonacci(20));
        for (int i = 1; i <=20 ; i++) {
            System.out.print(getFibonacci(i)+" ");
        }
    }
    public static int getFibonacci(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else {
            return getFibonacci(n-1) + getFibonacci(n-2);
        }
    }
}
