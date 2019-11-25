package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器iterator接口
 * 1.内部的方法：hasNext()和next()
 * 2.集合对象每次调用iterator()方法都会得到一个全新的迭代器对象
 *   默认游标都在集合的第一个元素之前
 * 3.内部定义了remove(),可以在遍历的时候删除集合中的元素，
 *   此方法不同于集合直接调用remove()方法
 *
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //得到迭代器对象
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //错误方式一：
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
//        while (coll.iterator().hasNext()){
//            System.out.println(iterator.next());
//        }
        /*
        会造成死循环，因为每当集合对象调用iterator()方法时，
        都会获取一个新的迭代器对象，并且指针指向的是第一个元素
        的前面一行，因此会一直循环输出第一个的元素
         */
    }


    //测试Iterator中的remove()方法
    /*
    如果还未调用next()或者在上次调用了next方法之后已经调用了remove方法，
    再调用remove都会报IllegalStateException
     */
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //首先还是先会去迭代器对象
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            //因为我们没有标注集合的泛型，因此这里用Object接收
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                //删除集合中"Tom"
                iterator.remove();
            }
        }

        System.out.println(coll);
    }

}
