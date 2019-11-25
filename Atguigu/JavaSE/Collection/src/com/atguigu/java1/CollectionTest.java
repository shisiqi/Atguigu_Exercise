package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *  1.集合、数组都是对多个数据进行存储操作的结构，简称java容器
 *      说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 *  2.1 数组在存储多个数据方面的特点：
 *      >一旦初始化完成之后，长度就确定了
 *      >数组一旦定义好，其元素的类型也就确定了 如：String[] arr，
 *      我们也就只能操作指定类型的数据了
 *  2.2 数组在存储多个数据方面的缺点：
 *      >一旦初始化完成之后，其长度就不可修改了
 *      >数组中提供的方法非常有限，对于添加，删除，插入数据等操作，非常不便
 *      >获取数组中实际元素的个数的需求，数组没有现成的属性或者方法可用
 *      >数组存储数据的特点：有序，可重复；对于无序，不可重复不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个对象的
 *          |----list接口：存储有序的、可重复的数据    "动态数组"
 *              |----ArrayList、LinkedList、Vector
 *          |----Set接口：存储无序的、不可重复的数据
 *              |----HashSet、LinkedHashSet、TreeSet
 *     |----Map接口：双列集合，用来存储一对（key-value）一对的数据
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * Collection接口方法的使用
 *
 * 向Collection接口的实现类中添加数据obj时，要求obj所在的类重写equals()方法
 */
public class CollectionTest {


    @Test
    public void test1(){
        Collection c = new ArrayList();

        //1.add(Object e)：将元素添加到集合中
        c.add("aa");
        c.add(123);//自动装箱，把int类型的数据自动转换成Integer包装类
        c.add(new Date());

        //2.size()：获取添加元素的个数
        System.out.println(c.size());//3

        //3.addAll(Collection c1)：把另外一个集合中的元素添加到当前集合中
        Collection c1 = new ArrayList();
        c1.add("bb");
        c1.add(456);
        c.addAll(c1);
        System.out.println(c);

        //4.contains(Object obj)：判断当前集合中是否包含obj
        //会去调用obj对象所在类的equals方法
        System.out.println(c.contains(123));


        c.clear();//5.clear()：清空几何中的所有元素


        //6.isEmpty()：判断当前集合是否为空
        /**
         * public boolean isEmpty() {
                return size == 0;
           }
         */
        System.out.println(c.isEmpty());//true

        //7.containsAll(Collection coll2);
        //判断当前集合是否包含coll2中的所有元素


    }


    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //1.remove(Object obj)：从当前集合中移除obj元素
        coll.remove(123);
        System.out.println(coll);

        /*
        若想要删除集合中自定义类的元素，则必须让该类实现equals方法
        remove方法会先去集合中寻找是否含有指定需要删除的元素，就是调用
        equals()方法进行寻找、比较，若返回true则表示集合中有指定需要删除的元素；
        若返回false则表示没有；若没有重写，则默认调用的是Object中的equals，
        比较的是对象的地址；而此处的对象都是new出来的，地址肯定不一致，
        因此比较地址值没有意义，我们需要在Person类中对equals方法进行实现，
        让它去比较对象的内容。（重要！！！）
         */
        boolean b = coll.remove(new Person("Jerry", 20));
        System.out.println(b);
        System.out.println(coll);

        //2.removeAll(Collection coll1);从当前集合中移除coll1中所有的元素
        //把两个集合中的交集删除
        //其实removeAll()方法的底层也是调用equals方法
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }


    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Collection coll1 = Arrays.asList(123,4567);
        //1.retainAll(Collection coll1):获取当前集合和coll1集合的交集，并返回给当前集合
        coll.retainAll(coll1);
        System.out.println(coll);

        //2.equals(Object obj)：要想返回true,需要当前集合和形参集合的元素都相同
        //Set集合因为本身就无序，而list集合需要保证元素的顺序也相同
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //1.hashCode();返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //2.集合--->数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length ; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组--->集合：调用Arrays的静态方法 asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
    }
}

class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
