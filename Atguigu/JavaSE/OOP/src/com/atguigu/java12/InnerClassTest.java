package com.atguigu.java12;

/**
 * 类的内部成员之五：内部类
 *  1.Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
 *  2.内部类分类：成员内部类、局部内部类（方法内，代码块内，构造器内）
 *  3.成员内部类：
 *      一方面，作为外部类的成员：
 *          >调用外部类的结构
 *          >可以被static修饰
 *          >可以被4种不同的权限修饰
 *
 *      另一方面：作为一个类：
 *          >类内可以定义属性、方法、构造器等
 *          >可以被final修饰，表示此类不能被继承；言外之意，若不被final修饰，就可以被继承
 *          >可以被abstract修饰,则该类此时就不能被实例化了
 *
 *  4.关注如下的3个问题：
 *      4.1 如何实例化成员内部类的对象
 *      4.2 如何在成员内部类中区分调用外部类的结构
 *      4.3 开发中局部内部类的使用
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //创建EE类的实例(静态的成员内部类)
        Person.EE ee = new Person.EE();
        ee.show();//talk is cheap,show me the code
        //创建DD类的实例（非静态的成员内部类）
        Person p = new Person();
        Person.DD dd = p.new DD();
        dd.sing();//我是一只小小鸟
        dd.display("shisiqi");
    }
}

class Person{

    String name = "小明";
    int age;
    public void eat(){
        System.out.println("人，吃饭");
    }



    //静态成员内部类
    static class EE{
        String name;
        int age;
        public void show(){
            System.out.println("talk is cheap,show me the code");
        }



    }

    //非静态成员内部类
    class DD{
        String name = "akke";//内部类中声明属性

        public DD() {//内部类中声明构造器
        }

        public void sing(){
            System.out.println("我是一只小小鸟");

            //内部类可以调用外部类的方法
            //注意：这里省略的是Person.this.
            eat();
        }

        public void display(String name){
            //如果方法的形参和内部类或外部类的成员变量有重名，
            // 默认都是按照就近原则取值
            System.out.println(name);//调用形参中的name 输出：shisiqi
            System.out.println(this.name);//调用当前类的成员变量name 输出：akke
            System.out.println(Person.this.name);//调用Person类的name 输出：小明
        }
    }

    {   //声明代码块中的局部内部类
        class BB{

        }
    }

    public Person() {
        //声明在构造器中的局部内部类
        class CC{

        }
    }

    public void method(){
        //声明方法内的局部内部类
        class AA{

        }
    }
}

