package com.atguigu.java7;

public class Person {
    String name;
    int age;
    int id = 100;//父类中的id代表身份证号

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    public void eat(){
        System.out.println("人：吃饭");
    }
    public void walk(){
        System.out.println("人：走路");
    }
}
