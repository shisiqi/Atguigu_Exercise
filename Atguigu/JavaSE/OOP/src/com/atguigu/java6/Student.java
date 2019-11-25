package com.atguigu.java6;

public class Student extends Person {
    String major;
    public  Student(){}

    public Student(String major) {
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生应该多吃有营养的食物");
    }

    public void study(){
        System.out.println("学习，专业是：" + major);
    }
}
