package com.atguigu.java8;

/**
 * 面向对象特征之三：多态性
 *
 *  1.理解多态性：可以理解为一个事物地多种形态
 *  2.何为多态性：父类引用指向子类对象
 *  3.多态的使用：虚拟方法调用
 *      有了对象的多态性以后，我们在编译器，只能调用父类中声明的方法
 *                          但在执行期，我们实际执行的是子类重写父类的方法
 *    总结：编译看左边，运行看右边
 *
 *  4.多态性的使用前提：1）类的继承关系
 *                    2）要有方法的重写
 *  5.对象的多态性，只适用于方法，不适用于属性（属性编译运行都看左边）
 *
 *  ******************************************************************
 *
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.age = 25;
        man.earnMoney();

        System.out.println("**************************");
        //多态性：父类引用指向子类对象
        Person p2 = new Man();
        //多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
        p2.eat();
        p2.walk();
        //p2.earnMoney();

        System.out.println(p2.id);//得到的是父类中定义的属性；编译看左边，运行看右边指的是方法（属性编译运行都看左边）

        System.out.println("***********************************");

       //无法调用子类所特有的方法，属性；编译时，p2是Person类型
        // p2.isSmoking;
        //p2.earnMoney();
        /** 多态的缺点：无法调用子类特有的方法
         * 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，
         * 导致编译时只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用
         */

        //如何才能调用子类特有的属性和方法？
        //使用强制类型转换符，向下转型
        //Man man1 = (Man) p2;
        //但是这样的强制类型转换会有风险，会出现类型转换异常（ClassCastException）
        //为了避免出现类型转换异常，需要使用instanceof关键字
        /*
         *instanceif关键字的使用：
         *  a instanceof A:判断对象a是否是类A的实例；若是返回true,若不是返回false;
         *  一旦返回的是true说明对象是该类的实列，就进行向下强转；如果返回false,不进行向下强转
         *
         *
         */
        if (p2 instanceof Man){
            Man man1 = (Man) p2;
            //向下转型之后就能调用子类特有的属性和方法了
            System.out.println(man1.isSmoking);
            man1.earnMoney();
        }


        /**
         * 练习：
         *  问题一：编译时能通过，但运行时报错
         */
        Person p3 = new Woman();
        //Man man2 = (Man) p3;//java.lang.ClassCastException


        //问题二：编译通过，运行也能通过
        Object obj = new Woman();
        Person p4 = (Person) obj;

        //问题三：编译不通过
        //Man man5 = new Woman();

    }
}
