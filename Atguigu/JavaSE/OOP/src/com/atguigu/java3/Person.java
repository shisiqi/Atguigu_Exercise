package com.atguigu.java3;

/**
 * 创建程序，在其中定义两个类：Person和PersonTest类，定义如下：
 * 用setAge()设置人的合法年龄（0~130），getAge()返回人的年龄。
 *
 *
 */
public class Person {

    private int age;

    public void setAge(int a) {
        if (0<= a && a<=130){
            age = a;
        }else {
            throw new RuntimeException("传入的数据非法");
        }
    }

    public int getAge() {
        return age;
    }
}
