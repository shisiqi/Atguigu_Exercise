package com.atguigu.java8;

/**
 *  多态性的使用举例一：
 *
 */
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        animalTest.func(new Dog());
    }

    /**
     * 如果没有多态，那我们若要调用子类的方法只能再去创建两个方法
     * public void func(Dog dog){
     *     ......
     * }
     * public void func(Cat cat){
     *     ......
     * }

     */
    public void func(Animal animal){   //实参为子类对象，形参为声明的父类引用；Animal animal = new Dog()
        //调用只能调用父类中的方法，执行的时候会执行子类中重写的方法
        animal.eat();
        animal.shout();
    }
}

class Animal{


    public void eat(){
        System.out.println("动物，进食");
    }
    public void shout(){
        System.out.println("动物，叫");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }
    public void shout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void shout(){
        System.out.println("喵喵喵");
    }
}