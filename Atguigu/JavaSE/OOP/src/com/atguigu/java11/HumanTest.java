package com.atguigu.java11;

public class HumanTest {
    public static void main(String[] args) {
        Worker worker = new Worker();
        method1(worker);//非匿名的类非匿名的对象
        method1(new Worker());//非匿名的类匿名对象

        System.out.println("**********************************************");
//        Human human = new Human() {//匿名类  new 抽象类或者new 接口
//            //不用像前面一样去写一个子类去继承Human，
//            // 直接new 抽象类即可，只使用一次
//            @Override
//            public void eat() {
//                System.out.println("吃东西");
//            }
//
//            @Override
//            public void breath() {
//                System.out.println("好好呼吸");
//            }
//        };
//
//        method1(human);

        //匿名对象+匿名类
        method1(new Human() {
            @Override
            public void eat() {
                System.out.println("吃好吃的东西");
            }

            @Override
            public void breath() {
                System.out.println("呼吸新鲜空气");
            }
        });

    }


    /*
        多态的使用：
            编译时调的是父类的方法
            运行时运行的是子类中重写的方法
    */
    public static void method1(Human human){

        human.eat();
        human.breath();
    }
}
class Worker extends Human{

    @Override
    public void eat() {

    }

    @Override
    public void breath() {

    }
}