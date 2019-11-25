package com.atguigu.java12;

/**
 * 接口的使用
 * 1.接口使用Interfsce来定义
 * 2.java中接口和类是并列的两个结构
 * 3.如何定义接口：定义接口中的成员
 *      3.1 JDK7及以前：只能定义全局常量和抽象方法
 *          什么是全局常量：public static final的,但是书写时可以省略不写
 *          抽象方法：public abstract的
 *
 *      3.2 JDK8：除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法(略)
 * 4.接口中不能定义构造器！意味着接口无法实例化。
 * 5.java开发中，接口通过让类去实现(implements)的方式来使用
 *  如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化；
 *  如果实现类没有覆盖了接口中的所有抽象方法，则此实现类仍为一个抽象类
 *
 * 6.java类可以实现多个接口 --->弥补了java单继承性的局限性
 *      格式：class AA extends BB implements CC,DD,EE
 * 7.接口和接口之间可以继承，且可以多继承
 * 8.接口的具体使用，体现多态性
 * 9.接口，实际上可以看成是一种规范
 * 面试题：接口和抽象类有哪些异同？
 */
public class InterfaceTest {
    public static void main(String[] args) {
        //证明接口中的常量是 public static final的
        //1，证明常量默认是被static修饰的，能用类名直接调用
        System.out.println(Flyable.MAX_SPEED);
        //2.不能对常量重新赋值
        //Flyable.MAX_SPEED = 2;
    }
}

interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    int MIN_SPEED = 1;//省略了public static final

    //抽象方法
    public abstract void fly();

    void stop();//省略了public abstract

    //public Flyable(){}  接口中无法定义构造器
}


interface Attackable{
    void attack();
}
class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

class Bullet implements Flyable,Attackable{//子弹可以实现两个接口
    //java中可以实现多个接口，打破了单继承的局限性
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }

}

interface AA{
    void method1();
}
interface BB{
    void method2();
}
interface CC extends AA,BB{
    //CC接口中相当于已经从父类接口中继承过来两个抽象方法
}
