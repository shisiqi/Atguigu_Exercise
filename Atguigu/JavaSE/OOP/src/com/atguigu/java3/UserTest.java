package com.atguigu.java3;

public class UserTest {
    public static void main(String[] args) {
        //构造器赋值
        User user = new User(2);
        System.out.println(user.age);//2

        //通过set方法赋值
        user.setAge(3);
        System.out.println(user.age);//3
    }
}

class User{
    //显式初始化
    int age = 1;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
