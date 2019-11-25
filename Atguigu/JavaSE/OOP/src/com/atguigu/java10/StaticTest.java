package com.atguigu.java10;

/**
 * static关键字的使用
 * 1.static：静态的
 * 2.static可以说修饰属性、方法、代码块、内部类
 * 3.使用static来修饰属性：静态变量（类变量）
 *      3.1属性按是否使用static关键字修饰分为静态属性和非静态属性（实例变量）
 *      实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性
 *          当修改其中一个对象的非静态属性时，不会导致其他对象中同样属性值得修改
 *      静态变量：我们创建了类的多个对象，多个对象都共享同一个静态变量。当通过某一
 *          个对象去修改静态变量时，会导致其他对象在调用静态变量时，是修改过的
 *      3.2static修饰属性的其他说明：
 *          1）静态变量随着类的加载而加载（实例变量随着对象的创建而加载的）
 *              可以通过类.静态变量的方式进行调用
 *          2）静态变量的加载要早于对象的创建
 *          3）由于类只会加载一次，则静态变量在内存中也只会存在一份：
 *          存在于方法区的静态域中
 *          4）    类变量    实例变量
 *          类       yes       no
 *          对象     yes      yes
 *      3.3静态属性举例：System.out,Math.PI
 * 4.使用static来修饰方法
 *      1）随着类的加载而加载，可以通过"类.静态方法"的方式进行调用
 *
 *      2)           静态方法   非静态方法
 *      类           yes         no
 *      对象          yes        yes
 *      3)静态方法中，只能调用静态的方法或属性
 *       非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * 5.static注意点：
 *      5.1在静态方法内，不能使用this关键字、super关键字
 *      this代表当前对象，而static加载进内存的时候，对象还没有被创建出来
 *      5.2关于静态变量和静态方法的使用，从生命周期的角度去理解
 *
 * 6.开发中如何确定一个属性需要static？
 *          属性是被多个对象所共享的，不会随着对象的不同而不同的。
 *   开发中如何确定一个方法需要static
 *          操作静态属性的方法，通常设置为static
 *          工具类中的方法，习惯上声明为static. Arrays,Collections,Math
 */
public class StaticTest {
    public static void main(String[] args) {

        //可以在创建对象之前，直接用类名.
        Chinese.nation = "CHINA";
        System.out.println(Chinese.nation);

        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 40;


        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 30;

        c1.nation = "中国";
        //没有给c2的nation赋值
        System.out.println(c2.nation);//中国
    }
}
class Chinese{
    String name;
    int age;
    static String nation;

    public void eat(){
        System.out.println("中国人吃中餐");

        //非静态方法中可以调用静态方法
        show();
        this.info();//调用非静态方法，this.可以省略

    }

    public void info(){
        System.out.println("name = " + name +",age = "+ age);
    }

    public static void show(){
        System.out.println("我是一个中国人");
        //eat();静态方法不能调用非静态方法
        //name = "tom";在静态方法中也无法使用非静态的属性
        System.out.println(nation);//静态方法中可以调用静态属性，这里省略Chinese.
        walk();//静态方法中可以调用静态方法
    }

    public static void walk(){

    }

}
