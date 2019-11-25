package com.atguigu.java2;

/**
 *  递归方法的使用（了解）：
 *      1.定义：一个方法体内调用它自身
 *      2.方法的递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无需循环控制
 *      3.递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环
 *
 */
public class RecursionTest {
    public static void main(String[] args) {
        //例1：计算1-100之间所有自然数的和
        //方法一：使用for循环
        int sum = 0;
        for (int i = 1; i <=100 ; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

        //方式二：
        System.out.println("使用递归求和得：" + getSum(100));
    }

    public static int getSum(int n){
        if (n == 1){
            return 1;
        }else {
            return n + getSum(n-1);
        }
    }
}
