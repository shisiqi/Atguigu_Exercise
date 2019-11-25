package com.atguigu.java2;

/**
 * 可变个数形参的方法
 * 1.jdk5.0新特性
 * 2.具体使用：
 *      2.1、可变个数形参的格式：数据类型...形参
 *      2.2、当调用可变个数形参的方法时，传入参数的个数可以是0个，1个，2个。。。
 *      2.3、可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
 *      2.4、可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载，
 *            二者二选一，不能共存
 *      2.5、可变个数形参在方法的形参中，必须声明在末尾
 *      2.6、可变个数形参在方法的形参中，最多只能声明一个可变形参
 */

public class MethodArgsTest {
    public static void main(String[] args) {
        MethodArgsTest methodArgsTest = new MethodArgsTest();
        methodArgsTest.show(12);
        methodArgsTest.show(1,"shisiqi","niubi");
    }
    public void show(int i){
        System.out.println(i);
    }
    public void show(String str){
        System.out.println(str);
    }
    public void show(int a ,String... strs){
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] +" ");
        }
    }
}
