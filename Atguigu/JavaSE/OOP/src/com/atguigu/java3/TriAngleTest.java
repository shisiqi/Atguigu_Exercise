package com.atguigu.java3;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle triAngle = new TriAngle(3,4);
        int base = triAngle.getBase();
        int height = triAngle.getHeight();
        System.out.println("三角形面积为:" + base*height);
    }
}
