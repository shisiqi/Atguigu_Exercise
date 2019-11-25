package com.atguigu.java3;

/**
 * 编写两个类，TriAngle和TriAngleTest,其中TriAngle类中声明
 * 私有的底边长base和高height,同时声明公共方法访问私有变量。
 * 此外提供类必要的构造器。另一个类中使用这些公共方法，计算
 * 三角形的面积
 *
 */
public class TriAngle {

    public TriAngle() {
    }

    public TriAngle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    private int base;
    private int height;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
