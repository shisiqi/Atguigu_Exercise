package com.atguigu.java10;

public class SingletonTest2 {
    public static void main(String[] args) {
        Person person1 = Person.getInstance();
        Person person2 = Person.getInstance();
        System.out.println(person1 == person2);//true
    }
}

class Person{
    //1.私有化类的构造器
    private Person(){}
    //2.声明当前类的对象，没有初始化
    //4，此对象必须声明为static
    private static Person person = null;
    //3.声明public,static的返回当前类对象的方法
    public static Person getInstance(){
        if (person == null){
            person = new Person();
        }
        return person;
    }
}
