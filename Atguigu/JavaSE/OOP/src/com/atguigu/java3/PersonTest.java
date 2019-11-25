package com.atguigu.java3;

/**
 * 在PersonTest类中实例化Person类的对象b，调用setAge()和getAge()方法，
 *  体会java的封装性
 */
public class PersonTest {
    public static void main(String[] args) {
        Person b = new Person();
        b.setAge(10);
        System.out.println(b.getAge());
    }
}
