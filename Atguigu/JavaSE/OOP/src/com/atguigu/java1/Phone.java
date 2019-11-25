package com.atguigu.java1;


public class Phone {
    double price;

    public void sendEmail(){
        System.out.println("发送邮件");
    }

    public void playGame(){
        System.out.println("玩游戏");
    }

    public void showPrice(){
        System.out.println("手机价格为：" + price);
    }
}
