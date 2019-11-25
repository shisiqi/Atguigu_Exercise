package com.atguigu.java;

/**
 * 测试Thread类的常用方法
 * 1.start()：启动当前线程，调用当前线程的run()方法
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程需要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield()：释放当前CPU的执行权
 * 7.join()：在线程A中调用线程B的join方法，
 * 此时线程A就进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 */

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }

//            if (i%20 == 0 ){
                //当前线程暂时放弃CPU的执行权
//                yield();
//            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.setName("线程一");
        helloThread.start();

        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }

            if (i == 20){
                try {
                    //当主线程输出数字20时，让线程一参与进来
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
