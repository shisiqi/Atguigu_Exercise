package com.atguigu.java1;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * List接口：存储有序，可重复的数据。-->动态数组，替换原有的数组
 *      |----ArrayList：作为List接口的主要实现类;线程不安全，效率高；
 *                      底层使用Object[] elementData存储
 *      |----LinkedList：对于频繁地插入、删除操作，使用此类效率比ArrayList高；
 *                      底层使用双向链表存储，
 *      |----Vector：作为List接口的古老实现类；线程安全，效率低；
 *                      底层使用Object[] elementData存储
 *
 *  2.ArrayList源码分析：
 *      2.1 jdk7情况下
 *      ArrayList list = new ArrayList();
 *      //底层创建了长度为10的object[]数组elementData
 *      list.add(123);//elementData[0] = new Integer(123)
 *      ...
 *      list.add(11)//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *      默认情况下，扩容为原来的1.5倍，同时将原有数组中的数据复制到新的数组中
 *
 *      结论：开发中建议使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *      2.2 jdk8中ArrayList的变化：
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}
 *          并没有创建长度为10的数组
 *          list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，
 *          并将123添加到elementData[0]
 *          。。。
 *          后续的添加和扩容操作与jdk7无异
 *      2.3 小结：jdk7中ArrayList的创建类似于单例的饿汉式，而jdk8中的ArrayList
 *          对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存
 *
 *   3.LinkedList的源码分析：
 *      LinkedList list = new LinkedList();
 *      //内部声明了Node类型的first和last属性，默认值为Null
 *
 *      list.add(123);//将123封装到Node中，创建了Node对象
 *      其中，Node定义为：体现类LinkedList双向链表的说法
 *      private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }
    4.Vector源码分析：jsk7和8通过构造器创建Vector()构造器创建对象时，底层都创建了
                    长度为10的数组在扩容方面，默认扩容为原来数组的2倍
 *
 *  面试题：比较ArrayList、LinkedList、Vector的异同
 *  同：三个类都实现了List接口，存储数据的特点相同：存储有序，可重复的数据
 *  不同：见上
 *
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list  = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",12));
        list.add(456);
        System.out.println(list);//[123, 456, AA, Person{name='tom', age=12}, 456]

        //1.void add(int index,Object ele)：在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //[123, BB, 456, AA, Person{name='tom', age=12}, 456]
        //从第二个位置起，整个数组往后移动一位，把BB插入到第二个位置

        //2.addAll(int index,Collection eles)：从index位置开始将eles中的所有元素加进来
        //先通过Array的静态方法asList得到一个list集合对象
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(0,list1);
        System.out.println(list);
        //[1, 2, 3, 123, BB, 456, AA, Person{name='tom', age=12}, 456]
        //区别于list.add(list1)：把list1当作一个整体元素加入到list中


        //3.Obejct get(int index)：获取指定index位置的元素
        System.out.println(list.get(4));//BB

        //4.int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(456));//8

        //5.Object remove(int index)：移除指定index位置的元素，并返回此元素
        list.remove(0);//把索引为0的元素删除
        System.out.println(list);
        //[2, 3, 123, BB, 456, AA, Person{name='tom', age=12}, 456]


        //6.Object set(int index,Object ele)：设置指定index位置的元素为ele
        list.set(0,"shisiqi");//把索引为0的元素设置成字符串"shisiqi"
        System.out.println(list);
        //[shisiqi, 3, 123, BB, 456, AA, Person{name='tom', age=12}, 456]


        //7.List subList(int fromIndex,int toIndex)：返回从fromIndex到toIndex位置的子集合
        List list2 = list.subList(0, 4);//含头不含尾
        System.out.println(list2);//[shisiqi, 3, 123, BB]
    }

    @Test
    public void test2(){
        /*
        区分list.remove(int index)和remove(Object obj)
         */
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);

    }

    private static void updateList(List list){
        list.remove(2);
        //list.remove(int index);
        //list.remove(Object obj);
        //判断是删除索引为2的元素，还是删除值为2的元素
        //此处应该是删除索引为2的元素，能用int类型参数列表的重载函数，
        //没必要再去自动装箱成包装类
        //若非要使用参数列表的参数为包装类的，只能手动装箱
        //即list.remove(new Integer(2));
    }

}
