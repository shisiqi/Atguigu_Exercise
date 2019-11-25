package com.atguigu.java11;

/**
 * abstract关键字的使用
 * 1.abstract：抽象的
 * 2.abstract可以用来修饰的结构：类、方法
 * 3.abstract修饰类：抽象类
 *      此类不能实例化
 *      抽象类中一定有构造器，便于子类实例化时调用（涉及到子类对象实例化全过程）
 *      开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作
 * 4.abstract修饰方法：抽象方法
 *      抽象方法中只有方法的声明，没有方法体
 *      包含抽象方法的类一定是抽象类；反之，抽象类中可以没有抽象方法
 *      若子类重写了父类中的所有的抽象方法后，方可实例化
 *      若子类重写了父类中的所有的抽象方法，则此子类也是一个抽象类，需要用abstract去修饰
 */
public class AbstractTest {

    public static void main(String[] args) {
        //被abstract继承的类不可实例化
//        Human human = new Human();
//        human.eat();
    }
}

abstract class Human extends Creature{
    String name;
    int age;

    public Human() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public void eat(){
//
//    } 这样不是抽象方法

    //抽象方法没有方法体，因此绝对不能写大括号
    public abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }
}
class Student extends Human{
    public Student() {
        /*
        构造器的首行如果没有显式地使用super或者this,
        则默认隐式地使用super()调用父类地空参构造
         */
    }

    //子类应该重写抽象父类中的所有抽象方法
    @Override
    public void eat() {
        System.out.println("学生多吃有营养的食物");
    }


    @Override
    public void breath() {
        System.out.println("学生应该呼吸新鲜空气");
    }
}

abstract class Creature{
    public abstract void breath();
}