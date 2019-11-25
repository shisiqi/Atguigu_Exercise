package com.atguigu.java9;

import java.util.Objects;

public class Customer {
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*@Override 手动定义equals()方法
    public boolean equals(Object obj) {
        //比较两个对象的实体内容是否相同即（name和age）
        if (this == obj){
            return true;
        }
        if (obj instanceof Customer){
            Customer customer = (Customer) obj;
            //比较两个对象的每个属性是否都相同
//            if (this.age == customer.age && this.name.equals(customer.name)){
//                return true;
//            }else {
//                return false;
//            }
            return this.age == customer.age && this.name.equals(customer.name);
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
