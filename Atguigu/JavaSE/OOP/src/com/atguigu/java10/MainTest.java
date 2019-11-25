package com.atguigu.java10;

/**
 * main方法的使用说明
 * 1.main()方法的程序入口
 * 2.main()方法也是一个普通的静态方法
 * 3.main()方法也可以作为我们与控制台交互的方式
 */
public class MainTest {
    public static void main(String[] args) {//入口
        Main.main(new String[100]);
    }
}

class Main{
    public static void main(String[] args) {
        for (int i = 0; i <args.length ; i++) {
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}
