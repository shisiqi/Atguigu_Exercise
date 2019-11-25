package com.atguigu.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 22.按要求完成如下操作
 1 ）封装一个汽车类，包含String  name、int  speed属性，在测试类中实例化三个对象：c1，c2，c3，
    分别设置name为：“奥拓”，“宝马”，“奔驰”，速度分别设置为：100,200,300
 2 ）使用Map集合对象m1将这三个汽车类对象保存成key，然后将int型的汽车价钱作为值保存在m1的value中，
    上述三款汽车分别对应的价钱是10000,500000,2000000
 3 ）遍历m1的键，打印name属性
 4 ）通过合适的方法，求出m1中“宝马”的价格，并打印结果；
 5 ）经过折旧，所有汽车都降价到原来的80%，请打印降价后“宝马”的价格

 */
public class CarTest1 {
    public static void main(String[] args) {
        Car1 car1 = new Car1("奥拓",100);
        Car1 car2 = new Car1("宝马",200);
        Car1 car3 = new Car1("奔驰",300);
        HashMap map = new HashMap();
        map.put(car1,10000);
        map.put(car2,500000);
        map.put(car3,2000000);

        //3.遍历m1的键，打印name属性
        Set set = map.keySet();
        for (Object o:
             set) {
            System.out.println(o);
        }
        //4.通过合适的方法，求出m1中“宝马”的价格，并打印结果
        Object o = map.get(car3);
        System.out.println(o);//2000000
        System.out.println("--------------------------------");
        //5.经过折旧，所有汽车都降价到原来的80%，请打印降价后“宝马”的价格
        //在遍历集合的时候，对原来集合中的价格进行修改
        Set set1 = map.entrySet();
        for (Object object:
             set1) {
            //获取key
            Map.Entry entry = (Map.Entry) object;
            Car1 key = (Car1) entry.getKey();
            //根据key获取value
            int value = (int) map.get(key);
            //对value进行修改
            value = (int) (value*0.8);
            map.put(key,value);
        }
        System.out.println(map);
    }
}

class Car1{
    private String name;
    private int speed;

    public Car1(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car1 car1 = (Car1) o;

        if (speed != car1.speed) return false;
        return name != null ? name.equals(car1.name) : car1.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + speed;
        return result;
    }
}

