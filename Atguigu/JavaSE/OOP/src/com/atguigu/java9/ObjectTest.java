package com.atguigu.java9;

/**
 *
 * java.lang.Object
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object
 * 3.Obejct 类中的功能（属性、方法）具有通用性
 * 4.Object类只声明了一个空参构造器
 * 5.属性：无
 * 6.方法：equals()/toString()/getClass()/hashCode()/clone()/finalize()/
 *      wait()/notify()、notifyAll()
 *
 *
 * 面试题：
 *  final、finally、finalize的区别？
 *  当对象在被回收之前，垃圾回收器会自动调用当前对象的finalize方法
 *
 *
 */
public class ObjectTest {

    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());//class java.lang.Object
    }
}
class Order{

}
