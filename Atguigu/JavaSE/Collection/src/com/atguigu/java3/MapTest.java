package com.atguigu.java3;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map实现类的结构
 * |---Map：双列数据，存储key-value键值对的数据
 *      |---HashMap：作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value
 *              |---LinkedHashMap：可以按照添加的顺序进行遍历
 *                  原因：在原有的HashMap底层结构的基础上，添加了一对指针，指向了
 *                  前一个和后一个元素。对于频繁地遍历操作，此类执行效率高于Map
 *
 *      |---TreeMap：可以按照添加的key-value进行排序，实现排序遍历。
 *                  此时考略key的自然排序定制排序，底层使用红黑树
 *      |---Hashtable：作为古老的实现类；线程安全，效率低；不可以存储null的key和value
 *              Properties：常用来处理配置文件。key和value都是String类型的
 *  HashMap的底层：数组+链表（jdk7之前）
 *                数组+链表+红黑树（jdk8）
 *
 *
 *  面试题：
 *  1.HashMap的底层实现原理？
 *  2.HashMap和Hashtable的异同
 *  3.currentHashMap与Hashtable的异同
 *
 *
 *  二、Map结构的理解：
 *      Map中的key是无序的、不可重复的，使用Set存储所有的key
 *          --->以HashMap为例，key所在的类要重写equals()方法和hashcode()方法
 *      Map中的value也是无序的，但是是可重复的，使用Collection存储所有的value
 *          --->value所在的类要重写equals()方法
 *      一个键值对：key-value构成了一个Entry对象。
 *     Map中的Entry：无序的、不可重复的，使用Set去存储所有的Entry。
 *  三、HashMap的底层实现原理？
 *     先以jdk7为例说明：
 *     HashMap map = new HashMap();
 *     在实列化以后，底层创建了长度为16的一维数组Entry[] table.
 *     ...可能已经执行过多次put操作了
 *     map.put(key1,value1);
 *     首先，调用key1所在类的hashCode方法计算key1的哈希值，此哈希值经过某种算法计算之后，
 *     得到在Entry数组中的存放位置。
 *     如果此位置上的数据为空，此时key1-value1添加成功；---情况1
 *     如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表的形式存在）），
 *     比较key1和已经存在的一个或多个数据的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。
 *                                          ---情况2
 *          如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较，
 *          调用key1所在类的equals(key2)方法比较
 *                  如果equals()方法返回false,此时key1-value1添加成功;
 *                                          ---情况3
 *                  如果equals()方法返回true,使用value1去替换相同key的value
 *     补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *     在不断的添加过程中，会涉及到扩容问题，当超出临界值且要存放的位置非空时，扩容；
 *     默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *
 *     jdk8相较于jdk7在底层实现方面的不同：
 *     1. new HashMap()：底层没有创建一个长度为16的数组
 *     2.jdk8底层的数组：Node[],而非Entry[]
 *     3.首次调用put方法时，底层去创建长度为16的数组
 *     4.jdk7底层结构只有数组+链表；jdk8中底层结构：数组+链表+红黑树
 *       当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8且
 *       当前数组的长度>64时，此时索引位置上的所有位置改为红黑树存储
 *          4.1若链表长度>8且当前数组的长度<64时，先去扩容数组；
 *          4.2若链表长度>8且当前数组的长度>64时,索引位置上的所有位置改为红黑树存储
 *
 *     DEFAULT_LOAD_FACTOR  HashMap的默认加载因子：0.75
 *     DEFAULT_INITIAL_CAPACITY  HashMap的默认容量：16
 *     threshold：扩容的临界值 = 默认加载因子*默认容量
 *     TREEIFY_THRESHOLD：索引位中链表长度>该默认值8，转化为红黑树
 *     MIN_TREEIFY_CAPACITY：数组中的Node被树化时最小的hash表容量（数组长度）：64
 *
 *     为什么HashMap要提前扩容，不像ArrayList一样等到不够时在扩容？
 *     因为HashMap存放数据的方式与ArrayList有很大的区别；
 *     ArrayList存放数据是一个一个的添加，添加满了，自然就不够了；
 *     HashMap添加数据是根据key的哈希值经过处理之后散列分布在数组中的某一索引位置，
 *     这样就有可能产生这样一个现象：有些索引位置常年没有数据占据，而有些索引位置，
 *     已经产生了链表结构，上面挂载了多个数据；因此它不能等到所有的索引位置全部被占满
 *     才想着去扩容，需要有一定的提前量，比如说占满了12个索引位的时候，就可以去扩容了；
 *     我们说，链表存在的情况越少越好；
 *     让Node尽量分布在数组中的不同索引位上(而不是在某一索引位上形成链表),这样查询效率更高；
 *      怎样让链表出现情况尽可能少？和加载因子的值有关，若加载因子的值位0.9，则需要扩容的最小
 *      数组长度为15，那么出现链表的概率或者说个数肯定大于需要扩容的最小数组长度为12的时候；
 *      但是加载因子的值也不能太小，太小的话，数组的利用率就有低了，原来的数组还有很多索引位
 *      没有被利用到；
 *
 *  四、LinkedHashMap底层实现原理（了解）
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;//能够记录添加元素的先后顺序
            Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
            }
        } 输出元素的顺序和添加元素的顺序一致

    五、Map中定义的方法：
  添加、删除、修改操作：
     Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     void putAll(Map m):将m中的所有key-value对存放到当前map中
     Object remove(Object key)：移除指定key的key-value对，并返回value
     void clear()：清空当前map中的所有数据
  元素查询的操作：
     Object get(Object key)：获取指定key对应的value
     boolean containsKey(Object key)：是否包含指定的key
     boolean containsValue(Object value)：是否包含指定的value
     int size()：返回map中key-value对的个数
     boolean isEmpty()：判断当前map是否为空
     boolean equals(Object obj)：判断当前map和参数对象obj是否相等
  元视图操作的方法：
     Set keySet()：返回所有key构成的Set集合
     Collection values()：返回所有value构成的Collection集合
     Set entrySet()：返回所有key-value对构成的Set集合
 *
 */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null,null);
        System.out.println(map);



        //Hashtable中无法存储null键和null值
//        Map map1 = new Hashtable();
//        map1.put(null,null);
//        System.out.println(,map1);
    }

    @Test
    public void test2(){
        //1.Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        System.out.println(map);//{AA=123, BB=456}

        //若出现key相同的情况,value2会替换value1
        map.put("AA",789);
        System.out.println(map);//{AA=789, BB=456}

        //2.void putAll(Map m):将m中的所有key-value对存放到当前map中
        //重新创建一个新的map集合
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",456);
        //把map1中的所有key-value全部存放到map中
        map.putAll(map1);
        System.out.println(map);//{AA=789, BB=456, CC=123, DD=456}

        //3.Object remove(Object key)：移除指定key的key-value对，并返回value
        map.remove("CC");//移除key为CC的键值对
        System.out.println(map);//{AA=789, BB=456, DD=456}

        //4.void clear()：清空当前map中的所有数据
        map.clear();
        System.out.println(map);//{}
    }

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        //1.Object get(Object key)：获取指定key对应的value
        Object aa = map.get("AA");
        System.out.println(aa);//123
        //若key不存在得到的value是null
        System.out.println(map.get("CC"));//null


        //2.boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey("AA"));//true

        //3.boolean containsValue(Object value)：是否包含指定的value
        System.out.println(map.containsValue(123));//true

        //4.int size()：返回map中key-value对的个数
        System.out.println(map.size());//2

        //5.boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());//false

        //6.boolean equals(Object obj)：判断当前map和参数对象obj是否相等




    }


    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);

        //遍历所有的key集：keySet()
        //1.Set keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集
        //2.Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        for (Object obj:
             values) {
            System.out.println(obj);//123 456
        }

        //返回所有的key-value
        //3.Set entrySet()：返回所有key-value对构成的Set集合
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() +"---->"+ entry.getValue());
            //AA---->123
            //BB---->456
        }
    }
}
