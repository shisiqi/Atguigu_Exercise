package com.atguigu.java11;

/**
 * final：最终的
 * 1.final可以用来修饰类、变量、方法
 * 2.final用来修饰类：此类不能被继承（String、System、StringBuffer）
 *      为什么String类被设计为不可继承的？因为在String类中所涉及到的一些
 *      属性和方法，String类本身就已经为你提供完全了，我们就算继承了String
 *      类也不能在它原有的基础上再添加或者扩展其他的功能和方法了
 * 3.final修饰一个方法：表明此方法不能被重写
 *         比如：Object类中的getClass();//获取当前对象所属的类
 *         public final native Class<?> getClass();中的native翻译过来是
 *         本地的，代表该方法要调用底层的C或者C++的代码来实现
 * 4.fianl用来修饰变量：此时的"变量"就成为了一个常量
 *      4.1 final用来修饰属性（成员变量），可以考虑赋值的位置有：
 *          显式初始化（即声明并初始化）、代码块中初始化、构造器中初始化
 *          *思考一下：为什么用final修饰的属性，不能在"对象.setXXX方法"中进行初始化？
 *          因为构造器是创建出对象的最后一道关卡，构造器一调用完，就要去加载对象
 *          的属性和方法，此时对象的属性应该全部已经赋值完毕，而setXXX方法是在原来
 *          赋值的基础上，对属性（成员变量）的值进行修改或重新赋值，因此属性的初始化
 *          不应该出现在setXXX方法中
 *      4.3 final修饰局部变量：
 *          1)方法内部的变量
 *          2）形参：表明此形参是一个常量，当我们通过对象去调用此方法时，给常量形参
 *          赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值
 *  static final 用来修饰属性：全局常量（在街口中，属性全部都是static final）
 *
 */
public class FInalTest {
    //final int a;--->final修饰的属性默认初始化会报错
    final int b;
    final int c;
    //a,b,c都是属性或者说成员变量
    final int width = 10;//final用来修饰属性，可以赋值的位置1：显式初始化

    public void dowidth(){

        //width = 20;被final修饰的变量不能被再次赋值
    }

    {
        b = 1;//final修饰属性，可以赋值的位置2：代码块中
    }

    public FInalTest(){
        c= 3;//final修饰属性，可以赋值的位置3:构造器中
    }




    public void show(){
        final int NUM = 4;//常量
        //num = 5;局部变量被final修饰，不能被再次赋值
    }

    public void show(final int num){
        //num = 20;被final修饰的形参不能被重新赋值
        System.out.println(num);//5-->被final修饰的形参只能被调用，不能被重新赋值
    }

    public static void main(String[] args) {
        FInalTest fInalTest = new FInalTest();
        fInalTest.show(5);//给局部变量（形参num）赋值
    }

}

final class FinalA{

}
//class B extends FinalA
//FinalA类不能被继承

class AA{
    public final void show(){}
}
class BB extends AA{
    //被final修饰的方法不能被重写
//    @Override
//    public void show() {
//        super.show();
//    }
}

