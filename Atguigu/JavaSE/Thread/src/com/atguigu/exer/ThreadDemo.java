package com.atguigu.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        mt.start();
//
//        MyThread1 mt1 = new MyThread1();
//        mt1.start();

        //既然Thread类的子类只使用一次可以考虑使用匿名对象的方式
        //创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run() {
                //在该线程中遍历100以内的奇数
                for (int i = 0; i < 100; i++) {
                    if (i%2 != 0){
                        System.out.println(Thread.currentThread().getName() +":"+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                //在该线程中遍历100以内的偶数
                for (int i = 0; i < 100; i++) {
                    if (i%2 == 0){
                        System.out.println(Thread.currentThread().getName() +":"+ i);
                    }

                }
            }
        }.start();


    }
}

//class MyThread extends Thread{
//    @Override
//    public void run() {
//        //在该线程中遍历100以内的奇数
//        for (int i = 0; i < 100; i++) {
//            if (i%2 != 0){
//                System.out.println(Thread.currentThread().getName() +":"+i);
//            }
//        }
//    }
//}
//
//class MyThread1 extends Thread{
//    @Override
//    public void run() {
//        //在该线程中遍历100以内的偶数
//        for (int i = 0; i < 100; i++) {
//            if (i%2 == 0){
//                System.out.println(Thread.currentThread().getName() +":"+ i);
//            }
//
//        }
//    }
//}
