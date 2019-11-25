package com.atguigu.java12;

/**
 * 开发中局部内部类的使用
 */
public class InnerClassTest1 {
    //返回一个实现
    public Comparable getComparable(){
        //创建一个实现Comparable接口的类;局部内部类
        //方式一：
//        class MyComparable implements Comparable{
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//
//        return new MyComparable();

        //方式二：
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}


