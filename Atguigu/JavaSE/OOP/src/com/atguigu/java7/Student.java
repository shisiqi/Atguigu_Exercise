package com.atguigu.java7;

public class Student extends Person {
    String major;
    int id = 101;//子类中的id代表学号

    public Student(){}

    public Student(String major) {
        this.major = major;
    }

    public Student(String name ,int age ,String major){

        //调用的是父类中指定参数的构造器
        super(name,age);
        this.major = major;
    }



    //重写快捷键：ctrl+o
    @Override
    public void eat() {
        System.out.println("学生：多吃有营养的食物");
    }

    public void study(){
        System.out.println("学生：学习知识");

        this.eat();//调用的是子类重写之后的方法
        super.eat();//调用的是父类被重写的方法
        //对于这种在父类中声明了，但是子类中没有重写的方法，其实写this.和super.区别并不大
        //唯一的区别就是this.是先去本类中找有没有这个方法？没找到，再去父类中找
        //而super.是直接去访问父类中的方法
        walk();
    }

    public void show(){
        //这里由于子类中没有声明name和age，我们都清楚这里的name和age都是继承自父类的属性
        //这里的name和age都是省略了this.
        System.out.println("name = " + this.name +",age = "+ super.age);

        //这里调用的是子类中的id,还是省略this.
        System.out.println("id = " + id);
        //这里用super.来调用父类中的id
        System.out.println("id = " + super.id );
    }
}
