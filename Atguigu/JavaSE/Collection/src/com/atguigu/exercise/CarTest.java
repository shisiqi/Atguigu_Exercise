package com.atguigu.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CarTest {
    /**
     *  5.创建Car类，包含name，price属性，构造器等方法，创建测试类，
     *  在main方法中创建Set接口的实现类，添加5个以上的Car对象，
     *  遍历集合元素，验证重复元素是否过滤了；如果没有过滤，实现过滤功能；
     *  把每个小车的price降10000元，再遍历，查看price是否已改变
     */
    public static void main(String[] args) {
        Set<Car> set = new LinkedHashSet<>();
        set.add(new Car("奔驰",20000.0));
        set.add(new Car("宝马",230000.0));
        set.add(new Car("法拉利",240000.0));
        set.add(new Car("兰博基尼",320000.0));
        set.add(new Car("大众",210000.0));
        set.add(new Car("大众",210000.0));
        Iterator<Car> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}


class Car{
    String name;
    double price;

    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.price, price) != 0) return false;
        return name != null ? name.equals(car.name) : car.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
