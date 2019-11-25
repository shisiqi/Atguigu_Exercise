package com.atguigu.java11;

/**
 *  类的成员之四：类的代码块（或初始化块）
 *      1.代码块作用：用来初始化类、对象
 *      2.代码块如果有修饰的话只能使用static
 *      3.分类：代码块根据是否用static修饰分为静态代码块和非静态代码块
 *      4.静态代码块
 *          内部可以有输出语句
 *          随着类的加载而执行，而且只执行一次
 *          （只要类没有重新加载，静态代码块就不会重新执行）
 *          作用：初始化类的信息
 *          如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 *          静态代码块的执行肯定是要优先于非静态代码块的执行
 *          静态代码块中只能调用静态属性和方法，不能调用非静态的结构
 *      5.非静态代码块
 *          内部可以有输出语句
 *          随着对象的创建而调用
 *          没创建一个对象，就会执行一次非静态代码块
 *          作用：可以在创建对象时，对对象的属性进行初始化
 *          如果一个类中定义了多个非静态代码块，则也按照声明的先后顺序执行
 *          非静态代码块内可以调用静态属性和方法，也能调用非静态属性和方法
 *  对属性可以赋值的位置：
 *      1.默认初始化
 *      2.显式初始化
 *      3.构造器初始化
 *      4.有了对象之后，若类中没有私有化成员变量，可以通过"对象.属性"进行初始化；
 *         若类中私有了成员变量，则通过"对象.setXXX"方法进行初始化
 *      5.在代码块中进行赋值
 */
public class BlockTest {
    public static void main(String[] args) {
        //若能调用静态变量，说明此时类已经加载到内存中
        String desc = Person.desc;//Hello,static block-1  Hello,static block-2
        /*
        而此时，类的静态变量和静态方法也将随着类的加载而加载到内存中
        但是如果我们不用"类.静态方法"去调用的话，静态方法是不会自己主动执行的
        而静态代码块是随着类的加载，而执行的；
         */

        /*
            除了可以在类中的成员变量位置处对属性进行初始化，
            还可以在静态代码块中对静态变量重新赋值操作
            因此随着类的加载，静态变量的重新赋值操作在静态代码块中执行
         */
        System.out.println(desc);//我是一个爱学习的人



        Person person1 = new Person();
        //创建对象的同时，代码块也执行了：Hello,block
        System.out.println(person1.name);//ssq
        /*
        由于在代码块中对属性进行了初始化（赋值）操作，
        因此无需通过构造器来初始化，也能通过"对象.属性"获取到属性的值
         */
    }
}

class Person{

    //属性
    String name;
    int age;
    static String desc = "我是一个人";
    //构造器
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //静态代码块

    static {
        System.out.println("Hello,static block-1");
    }

    static {
        System.out.println("Hello,static block-2");
        desc = "我是一个爱学习的人";
    }


    //代码块
    {
        name = "ssq";
        System.out.println("Hello,block");
    }

    //方法
    public void eat(){
        System.out.println("吃饭");
    }

    public static void info(){
        System.out.println("我是一个快乐的人！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
