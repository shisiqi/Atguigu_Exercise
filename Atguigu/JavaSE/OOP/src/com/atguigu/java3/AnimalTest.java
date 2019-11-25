package com.atguigu.java3;

/**
 * 面向对象的特征之一：封装与隐藏
 *  1.问题的引入：当我们创建一个类的以后，我们可以通过“对象.属性的方式”，对对象的属性进行赋值。
 *  这里赋值操作要受到数据类型和存储范围的制约，除此之外没有其他制约。但是在实际问题中，需要给属性赋值加入额外的
 *  限制条件。这个条件不能在声明属性时体现，我们只能通过方法进行限制条件的添加 (比如：setLegs())
 *  同时，我们需要避免用户再次使用“对象.属性”的方式对属性进行赋值，则需要将属性声明为私有的(private)
 *
 *  2.封装性的体现：
 *  我们将类的属性私有化(private)，同时提供公共的(public)方法来获取(getXXX)和设置此属性的值(setXXX)
 *
 *  3.封装性的体现需要权限修饰符来配合
 *      1.java规定的4种权限（从小到大排列）：private、缺省、protected、public
 *             |----private：私有的，在哪里声明的，就只能在哪里用，在类中声明的，在类外就没有访问权限
 *             |----default：只可以被同一个包内部使用
 *             |----protected：同一个包内部或者该包的子包中使用
 *             |----public：可以在任意地方被访问
 *      2.4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 *      3.具体的，4种权限修饰符都能用来修饰类的内部结构；
 *        修饰类的话，只能用缺省的（default）和public;
 *        (内部类可以用private修饰)
 * 总结：java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性大小
 */
public class AnimalTest {

    public static void main(String[] args) {
        Animal animal = new Animal();
        //animal.name = "大黄";
        //animal.age = 1;
        animal.setLegs(4);
        animal.show();

        //animal.legs = -4;不能随意对成员变量设置非法的值

    }
}

class Animal{
    private String name;
    private int age;
    private int legs;//腿的个数
    public void eat(){
        System.out.println("动物进食");
    }

    public void show(){
        System.out.println("name=" + name +",age="+ age + ",legs=" + legs);
    }

    //对属性的设置
    public void setLegs(int l){
        if (l>=0 && l%2 == 0) {
            legs = l;
        }else {
            legs = 0;
        }
    }
    //属性的获取
    public int getLegs(){
        return legs;
    }
}
