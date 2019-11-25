package com.atguigu.java2;

/**
 * 1.定义：在同一个类中，允许存在一个以上的同名方法，
 *  只要他们的参数个数或者参数类型不同即可
 *      |-----两同一不同：方法名相同，类名相同，参数列表不同
 * 2.判断是否重载：
 *      和方法的权限修饰符，返回值类型，形参变量名，方法体都没有关系！
 * 3.在通过对象调用方法时，如何确定某一个指定的方法？
 *      方法名-->参数列表
 *      如果出现方法名和参数列表相同的方法，编译器就懵了，不知道该调用哪个方法了
 */
public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest overLoadTest = new OverLoadTest();
        overLoadTest.getSum(1,2);
        overLoadTest.getSum(0.1,2.3);
    }

    public void getSum(int i ,int j){
        System.out.println("1");
    }

    public void getSum(double d1 , double d2){
        System.out.println("2");
    }
}
