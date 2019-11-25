package com.atguigu.java;

import java.io.FileOutputStream;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()方法
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()方法
 *
 * 例子：遍历100以内所有的偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread myThread = new MyThread();
        //4.通过此对象调用start()方法：1）启动当前线程2）调用当前线程的run方法
        myThread.start();
        /**
         * 问题一：我们不能通过直接调用run的方式启动线程。
         * 问题二：再想启动一个线程来遍历100以内的偶数
         * 不能让已经start的线程去执行
         */
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if ( i%2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+i + "*******main()*********");
            }
        }
    }
}


//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()方法
    @Override
    public void run() {
        //遍历100以内所有的偶数
        for (int i = 0; i < 100; i++) {
            if ( i%2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+i);
            }
        }
    }


}
