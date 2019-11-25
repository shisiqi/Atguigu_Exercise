package com.atguigu.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    /**
     * 1.向TreeSet中添加的数据，要求是相同类的对象
     * 2.两种排序方式：自然排序(实现Comparable接口)和定制排序
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo返回0,不再是equals()
     * 4.在定制排序中，比较两个对象是否相同的标准为：compare返回0,不再是equals()
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //失败：不能添加不同类的对象；
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("tom",12));


        //举例一：
//        set.add(1);
//        set.add(34);
//        set.add(-25);


        set.add(new Person("tom",12));
        set.add(new Person("tam",14));
        set.add(new Person("akke",24));
        set.add(new Person("jke",9));
        set.add(new Person("tom",29));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("输入数据的类型不匹配");
                }
            }
        });
        set.add(new Person("tom",12));
        set.add(new Person("tam",14));
        set.add(new Person("akke",24));
        set.add(new Person("jke",9));
        set.add(new Person("tom",29));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
