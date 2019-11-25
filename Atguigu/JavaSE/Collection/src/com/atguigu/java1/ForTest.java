package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0新特性 加强for循环用于遍历集合和数组
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素类型 局部变量:集合对象)
        //内部仍然调用迭代器
        for (Object obj: coll) {
            System.out.println(obj);
        }
    }


    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        for (int i: arr) {
            System.out.println(i);
        }
    }

    //练习题：

    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};
        //方式一：普通for循环
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for (String str:
             arr) {
            str = "GG";//给str赋值不会改变原有数组中的值
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);//MM MM MM
        }

    }
}
