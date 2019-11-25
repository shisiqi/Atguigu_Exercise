package com.atguigu.exer;

/**
 * 1.编写程序，定义3个重载方法并调用，方法名为mOL
 *  三个方法分别接受1个Int参数，2个int参数，一个字符串参数
 *  分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息
 *  在主类的main()方法中分别用参数区别调用三个方法
 *
 * 2.定义3个重载方法max()
 * 第一个方法求两个int值中的最大值
 * 第二个方法求两个double方法的最大值
 * 第三个方法求三个double值中的最大值
 * 并分别调用这三个方法
 *
 *
 *
 */
public class OverloadExer {
    public static void main(String[] args) {
        OverloadExer overloadExer = new OverloadExer();
        System.out.println(overloadExer.mOL(3));
        System.out.println(overloadExer.mOL(3,4));
        overloadExer.mOL("shisiqi");

        System.out.println(overloadExer.max(0,10));
        System.out.println(overloadExer.max(2.0,8.6));
        System.out.println(overloadExer.max(3.2,3.4,9.9));

    }

    public int mOL(int i){
        return i*i;
    }
    public int mOL(int i,int j){
        return i*j;
    }
    public void mOL(String str){
        System.out.println(str);
    }

    public int max(int a,int b){
        if (a>b){
            return a;
        }else {
            return b;
        }
    }

    public double max(double d1,double d2){
        if(d1 > d2){
            return d1;
        }else {
            return d2;
        }
    }

    public double max(double d1,double d2,double d3){
        if (d1 > d2 && d1 > d3){
            return d1;
        }else if (d2 > d3){
            return d2;
        }else {
            return d3;
        }
    }
}
