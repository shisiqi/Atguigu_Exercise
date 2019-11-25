package com.atguigu.java2;

/**
 * （1）定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个
 * findArea()方法返回圆的面积
 * （2）定义一个类PassObject,在类中定义一个方法printAreas(),该方法的定义如下：
 * public void printAreas(Circle c ,int time)
 * 在printAreas方法中打印出1到time之间的每个整数半径值，以及对应的面积。
 * 例如：,times为5，则输出半径1,2,3,4,5，以及对应的圆面积
 * （3）在main方法中调用printAreas()方法。调用完毕后输出当前半径值。
 *
 *
 */

public class ValueTransferTest4 {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject passObject = new PassObject();
        passObject.printAreas(c,5);

        System.out.println("now radius is :" + c.radius);
    }
}
class Circle{
    double radius;
    public double findArea(){
        return Math.PI*radius*radius;
    }
}
class PassObject{
    public void printAreas(Circle c ,int time){
        System.out.println("Radius\t\tArea");
        //设置圆的半径
        for (int i = 1; i <=time; i++) {
            c.radius = i;
            System.out.println(c.radius+"\t\t"+c.findArea());
        }
        c.radius = time + 1;
    }
}
