package com.atguigu.java1;

/**
 * 匿名对象的使用
 *  1.理解：我们创建的一个对象，没有显式地赋给一个变量名，即为匿名变量
 *  2.特征：匿名对象只能调用一次
 *  3.使用：
 */
public class InstanceTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        System.out.println(p);

        p.sendEmail();
        p.playGame();

        //匿名对象只能调用一次
        new Phone().price = 2000;
        new Phone().showPrice();//0.0

        //匿名对象的使用
        PhoneMall pm = new PhoneMall();
        //以后经常会这么用，形参指向匿名变量的地址值
        //相当于把匿名变量赋值给了形参变量phone
        pm.show(new Phone());
    }
}


class PhoneMall{
    public void show(Phone phone){
        phone.sendEmail();
        phone.showPrice();
    }
}