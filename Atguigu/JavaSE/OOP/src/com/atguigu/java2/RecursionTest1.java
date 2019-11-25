package com.atguigu.java2;

/**
 * 已知有一个数列，f(0)=1,f(1)=4,f(n+2)=2*f(n+1)+f(n),
 * 其中n是大于0的整数，求f(10)的值
 *
 */
public class RecursionTest1 {
    public static void main(String[] args) {
        System.out.println(getFn(10));
    }

    public static int getFn(int n){
        if (n == 0){
            return  1;
        }else if (n == 1){
            return 4;
        }else{
            return 2*getFn(n-1)+getFn(n-2);
        }
    }
}
