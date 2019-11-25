package com.atguigu.java2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1. Set接口的框架结构
 *      Set接口：存储无序、不可重复的数据
 *          |---HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *          |---LinkedHashSet：作为HashSet的子类；遍历其内部的数据时，可以按照
 *                              添加的顺序去遍历
 *                             对于频繁地遍历操作，LinkedHashSet效率高于HashSet
 *          |---TreeSet：可以按照添加对象的指定属性，进行排序
 *      Set接口中没有额外定义新的方法，使用的都是Collection中使用过的方法
 *
 *      注意：Object中的hashCode的方法是根据对象随机生成的一串数字。若我们所写的类没有重写
 *      hashCode方法，set.add()时调用的就是Object类中的hashCode()方法；因此就算两个相同
 *      的对象，得到的哈希值也是不同的，因此肯定分布在数组中的不同索引处，根本不会去进行比较；
 *      这样，就不能过滤掉相同的元素，做不到不可重复；
 *           你会发现，只要你没有在添加元素所在类中实现hashCode方法，添加重复元素后，
 *           所在集合中就会出现重复元素；不能达到去重的效果；
 *           因此需要在添加元素所在的类实现hashCode方法
 *
 *      要求：1.向Set中添加的数据，其所在的类一定要重写HashCode和equals方法
 *           2.重写的hashCode()和equals()尽可能保持一致：相等的对象必须具有相等的散列码
 *           比如在重写Person类的hashCode方法时，能保证若name的值相同则name.hashCode值也相同
 *           总之，重写HashCode方法的目的是：若两个对象的属性一致，能保证他们的哈希值一致；
 *                                         若两个对象的属性不一致，则他们的哈希值不一致；
 *           但是有一种极端情况：hashCode值相同，但是两个对象的属性值均不同，导致equals返回false；
 *           若equals返回false，我们就需要通过链表的形式把新添加进去的元素挂载在原来的元素下边；
 *           我们存储数据的原则就是，能不用链表，就不用链表；两个不同的对象，就应该让他们散列分布在
 *           数组的不同索引处，这样操作起来更加方便；为了达到这个目的，我们实现hashCode方法的时候，
 *           做了一系列操作（详情见下方hashCode方法处）让不同对象hashCode值相等的概率降到很低；
 *
 *
 */
public class SetTest {
    /*
      一、Set：存储无序的，不可重复的数据
      以HashSet为例说明：
      1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，
      而是根据数据的哈希值

      2.不可重复性：保证添加的元素按照equals判断时，不能返回true，即相同的元素只能添加一个

      二、添加元素的过程（以HashSet为例）
            我们向HashSet中添加元素a,首先调用元素a所在类的hashCode方法去计算元素a的哈希值，
            此哈希值通过某种算法计算出在HashSet底层数组中的存放位置（即在数组中的索引位置），
            判断在此位置上是否已经有元素；
            若此位置上没有其他元素，则元素a添加成功。-->情况1
            若此位置上有其他元素b（或在索引位置上以链表形式存在的多个元素），则比较元素a
            和元素b的哈希值；
                如果哈希值不相同，则元素a添加成功；-->情况2
                如果哈希值相同，进而需要调用元素a所在类的equals()方法；
                    如果equals()方法返回true,元素a添加失败；
                    如果equals()方法返回false,元素a添加成功； -->情况3
          对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上的其他数据
          以链表的方式存储；jdk7中，元素a放到数组中，指向原来的元素；
                          jdk8中，原来的元素放在数组中，指向元素a
                          总结：7上8下（新来的元素jdk7中在链表的最上面；新来的元素jdk8中在链表的最下面）
          HashSet底层：数组+链表的结构

     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        //set.add(123);//Set中数据不可重复
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("tom",12));
        set.add(new Person("tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2(){
        /*
        LinkedHashSet的使用
        LinkedHashSet作为HashSet的子类，在添加数据的同时，
        每个数据还维护了两个引用，记录了此数据的前一个数据和后一个数据。
        目的：对于频繁地遍历操作，LinkedHashSet效率高于HashSet
         */
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("tom",12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            //LinkedHashSet会与添加元素时相同的顺序进行输出
            System.out.println(iterator.next());
        }

    }

}

class Person implements Comparable{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("use equals。。。");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小,年龄从小到大
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p = (Person) o;
            //return this.name.compareTo(p.name);
            int compare = -this.name.compareTo(p.name);
            if (compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age,p.age);
            }
        }else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
