package com.atguigu.exercise;

import org.junit.Test;

import java.util.*;

/**
 * 集合章节练习题及面试题
 */
public class CollectionTest {

    @Test
    public void test1(){
        /**
         *
         * 1.定义一个Collection接口类型的变量，引用一个Set集合的实现类，
         * 实现添加单个元素，添加另一个集合，删除元素，判断集合中是否包含一个元素，
         * 判断是否为空，清除集合，返回集合里元素的个数等常用操作。
         */
        Collection hashSet = new HashSet();
        //添加单个元素
        hashSet.add("shisiqi");
        List list = new ArrayList();
        list.add("akke");
        list.add("loda");
        hashSet.addAll(list);
        System.out.println(hashSet);//[shisiqi, loda, akke]
        //当我们去输出集合的引用时，实际上就是去调用集合重写Object类的toString方法
        //底层肯定调用了toString方法，否则打印出的应该是集合的地址值

        //删除元素
        hashSet.remove("shisiqi");
        System.out.println(hashSet);//[loda, akke]

        //判断集合中是否包含一个元素
        System.out.println(hashSet.contains("akke"));//true-->集合中包含"akke"这个元素

        //判断集合是否为空
        System.out.println(hashSet.isEmpty());//false-->集合不为空

        //返回集合里元素的个数
        System.out.println(hashSet.size());//2

        //清除集合
        hashSet.clear();
        System.out.println(hashSet);//[]
    }


    @Test
    public void test2(){
        /**
         * 2.创建Set接口的实现类，添加10个以上的元素，
         * 通过Iterator遍历此集合元素。
         */

        Set<Integer> set = new HashSet();
        for (int i = 0; i < 11; i++) {
            set.add(i);
        }
        //1.获取Iterator接口
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }


    @Test
    public void test3(){
        /**
         *3.创建Set接口的实现类，添加10个以上的元素，
         * 通过foreach遍历此集合元素。
         */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 11; i++) {
            set.add(i);
        }

        /*
        加强for循环的格式
        for(集合中元素的数据类型 变量 ： 集合名称){
                xxx
        }
         */
        for (Integer i:
             set) {
            System.out.print(i + " ");
        }
    }


    @Test
    public void test4(){
        /**
         *
         * 4.创建Set接口的实现类，添加10个以上的元素，要求能够排序。
         * 4.1 若添加的元素类型是Integer类型的，则无需其他操作，
         * 因为Interger类已经实现了Comparable接口,内部会帮我实现
         * 数字的排序
         * 4.2若添加的元素类型是其他自定义类型的，需要让该类去实现
         * Comparable接口
         */
        /*
        set集合是无序的
         */
        //要实现定制排序：需要将实现Comparator接口的实例作为形参传给TreeSet的构造器
        TreeSet treeSet = new TreeSet();
        treeSet.add(5);
        treeSet.add(56);
        treeSet.add(1234);
        System.out.println(treeSet);//[1234, 56, 5]

    }


    @Test
    public void test6(){
        /**
         * 6.定义一个Collection接口类型的变量，引用一个List集合的实现类，
         * 实现添加单个元素，添加另一个集合，删除元素，判断集合中是否包含一个元素，
         * 判断是否为空，清除集合，返回集合里元素的个数等常用操作
         */

        Collection coll1 = new ArrayList();

        //添加单个元素
        coll1.add(123);

        //创建一个新集合
        Collection coll2 = new ArrayList();
        coll2.add("a");
        coll2.add("b");
        coll2.add("c");
        //添加另一个集合使用addAll()方法
        coll1.addAll(coll2);
        System.out.println(coll1);//[123, a, b, c]

        //删除集合中的元素
        coll1.remove(123);
        System.out.println(coll1);//[a, b, c]
        /**
         * 这里简单说明一下：为什么不使用ArrayList重载的remove(int index)方法
         * 因为我申明的是Collection coll1 = new ArrayList();多态的形式，父类引用
         * 指向子类对象。此时，编译看左边，运行看右边，也就是说只能调用Collection
         * 接口中定义的方法，编译才能通过；若想调用remove(int index)，则需要这样声明：
         *      ArrayList list = new ArrayList();
         */

        //判断集合中是否包含一个元素
        System.out.println(coll1.contains("a"));//true

        //判断集合是否为空
        System.out.println(coll1.isEmpty());//false

        //返回集合中的元素个数
        System.out.println(coll1.size());//3

        //清楚集合
        coll1.clear();
        System.out.println(coll1);//[]

    }


    @Test
    public void test7(){
        /**
         * 7.创建ArrayList实例化对象，添加10个以上的元素，
         * 在2号位插入一个元素，获得5号位元素，删除6号位元素，
         * 修改7号位的元素；
         */

        ArrayList list = new ArrayList(11);
        for (int i = 0; i < 11 ; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //在2号位插入一个元素
        list.add(2,"shisiqi");

        //获得5号位的元素
        Object o = list.get(5);
        System.out.println(o);

        //删除6号位元素
        list.remove(6);

        //修改7号位的元素
        list.set(7,"shijianxiong");
        System.out.println(list);

        System.out.println("---------------------------");




        /*
        8.通过四种方法遍历上题中的集合
         */

        //方式一：使用普通for循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("---------------------------");
        //方式二:使用迭代器
        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("---------------------------");
        //方式三：使用加强for循环
        for (Object obj :
             list) {
            System.out.println(obj);
        }

        System.out.println("---------------------------");
        //方式四：使用Lambda表达式的forEach
        list.forEach(System.out::println);
    }


    @Test
    public void test8(){
        /*
        9.创建LinkedList实例化对象，练习具有队列特点的方法
         */
        LinkedList list = new LinkedList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        for (Object obj:
                list) {
            System.out.print(obj + " ");
        }

        System.out.println();

        //对于整个集合的频繁地插入或者删除，
        // 使用LinkedList比使用ArrayList效率更高，
        //因为LinkedList使用的是链表来存储数据，每个
        //Node上都记录着上一个元素，当前元素和下一个元素
        //3个信息；若需要插入数据，只需要把插入处前后两个Node的
        //指向关系删除，让它们指向新增的这个Node即可；
        //而如果对ArrayList进行频繁地插入或者删除数据，
        //每一次的插入数据都会让数组整体向后挪一位，效率太低

        //在LinkedList中每逢偶数位都插入字符串"shisiqi"
        for (int i = 0; i <=20; i++) {
            if (i%2 == 0){
                list.add(i,"shisiqi");
            }
        }
        for (Object obj:
             list) {
            System.out.print(obj + " ");
        }
    }


    @Test
    public void test9(){
        /**
         * 11.定义一个Map接口类型的变量，引用一个实现类，
         * 添加键值对，判断集合中是否包含某一key值，通过某一key值得到value值，
         * 通过某一key删除键值对，把另一个map集合添加到此map集合，
         * 判断是否为空，清除集合，返回集合里元素的个数等常用操作。
         */

        //1.定义一个Map接口类型的变量
        Map map = new HashMap();
        //2.添加键值对
        map.put("name","shisiqi");
        map.put("age",16);
        map.put("sex","male");
        //3.判断集合中是否包含"name"这个key
        System.out.println(map.containsKey("name"));
        //4.通过某一key值得到value值
        System.out.println(map.get("age"));
        //5.通过某一key删除键值对
        map.remove("sex");
        System.out.println(map);
        //6.把另一个map集合添加到此map集合
        Map map1 = new HashMap();
        map1.put("height",181);
        map.putAll(map1);
        System.out.println(map);
        //7.判断是否为空
        System.out.println(map.isEmpty());
        //8.返回集合里元素的个数
        System.out.println(map.size());
        //9.清除集合
//        map.clear();
//        System.out.println(map);


        /**
         * 12.通过两种方法遍历上题中的map集合
         */

        //方法一：使用迭代器遍历
        //先获取Entry的set
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

        System.out.println("-----------------------------");
        //方式二：使用加强for循环
        //也是先获取EntrySet(前面已经获取过了，这边直接用),遍历entrySet
        for (Object obj:
             entrySet) {
            System.out.println(obj);
        }
    }


    @Test
    public void test10(){
        /**
         * 13.使用Map接口的实现类完成员工工资(姓名--工资)的摸拟：
         *      1)添加几条信息 2)列出所有的员工姓名 3列出所有员工姓名及其工资
         *      4)删除名叫“Tom”的员工信息 5)输出Jack的工资，并将其工资加1000元(通过取值实现)
         *      6)将所有工资低于1000元的员工的工资上涨20%(通过取值实现)
         */

        Map map = new HashMap();
        //1)添加几条信息
        map.put("Tom",2000);
        map.put("Jack",6000);
        map.put("Alice",7000);
        map.put("kaka",800);


        //2)列出所有的员工姓名
        Set set = map.keySet();
        for (Object obj:
             set) {
            System.out.println(obj);
        }

        System.out.println("------------------------------");
        //3列出所有员工姓名及其工资
        Set set1 = map.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

        //4)删除名叫“Tom”的员工信息
        map.remove("Tom");
        System.out.println(map);//{Alice=7000, Jack=6000, kaka=8000}

        //5)输出Jack的工资，并将其工资加1000元(通过取值实现)
        int salary = (int) map.get("Jack");
        System.out.println(salary);//6000
        map.put("Jack",7000);//当key相同时,会用新的value替换之前的value
        System.out.println(map);//{Alice=7000, Jack=7000, kaka=8000}

        System.out.println("--------------------------------");


        //6)将所有工资低于1000元的员工的工资上涨20%(通过取值实现)
        //先取出所有的value
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            int value = (int) entry.getValue();
            Object key = entry.getKey();
            if (value < 1000){
                value = (int) (value*(1+0.2));
                map.put(key,value);
            }

        }
        System.out.println(map);


    }

    @Test
    public void test11(){
        /**
         * 14.创建有序的map集合的实例化对象，
         * 添加元素，查看排序结果
         */
        Map map = new TreeMap();
        map.put("ccc",45);
        map.put("aaa",23);
        map.put("ddd",56);
        map.put("bbb",35);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }
    }


    @Test
    public void test12(){
        /**
         16.使用HashMap类实例化一个Map类型的对象m1，键（String类型）和值（int型）
         分别用于存储员工的姓名和工资，存入数据如下：
         张三——800元；李四——1500元；王五——3000元；
         1）将张三的工资更改为2600元
         2）为所有员工工资加薪100元；
         3）遍历集合中所有的员工
         4）遍历集合中所有的工资
         */

        HashMap map = new HashMap();
        map.put("张三",800);
        map.put("李四",1500);
        map.put("王五",3000);

        // 1）将张三的工资更改为2600元
        map.put("张三",2600);
        // 2）为所有员工工资加薪100元；(我就直接覆盖了)
        map.put("张三",2700);
        map.put("李四",1600);
        map.put("王五",3100);
        //3）遍历集合中所有的员工
        Set set = map.keySet();
        for (Object obj:
             set) {
            System.out.println(obj);
        }
        //4）遍历集合中所有的工资
        Set set1 = map.entrySet();
        for (Object obj:
             set1) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getValue());
        }
    }


    @Test
    public void test13(){
        /**
         * 17.创建一个List集合的对象，添加几个数字，
         * 反转对象中元素的顺序；根据元素的自然顺序排序；
         */
        List list = new ArrayList();
        //添加几个数字
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        //反转对象中元素的顺序
        Collections.reverse(list);
        System.out.println(list);

        //根据元素的自然顺序排序
        Collections.sort(list);
        System.out.println(list);
    }


    @Test
    public void test14(){
        /**
         * 18.创建一个List集合的对象，添加几个字符串，
         * 反转对象中元素的顺序；根据元素的自然顺序排序；
         */

        List list = new ArrayList();
        list.add("shisiqi");
        list.add("shijianxiong");
        list.add("kaka");
        list.add("akke");
        //反转对象中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
        //根据元素的自然顺序排序
        Collections.sort(list);
    }


    @Test
    public void test15(){
        /**
         * 19.创建一个List集合的对象，添加几条数据，
         *    将1号位和2号位交换；获得最大值，最小值，
         */
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        //将1号位和2号位交换
        Collections.swap(list,1,2);
        System.out.println(list);
        //获得最大值、最小值
        System.out.println(Collections.max(list));//3
        System.out.println(Collections.min(list));//1
    }


    @Test
    public void test16(){
        /**
         * 21，按要求完成如下操作
            1.	生成10个随机数，值在100到200之间；
            2.	将这十个数存入HashSet集合中（有可能集合的长度小于10）。
            3.	将这个HashSet集合转换成ArrayList集合
            4.	重新为ArrayList集合排序，按照从小到大的顺序；
            5.	使用foreach遍历集合；
         */
        HashSet set = new HashSet();
        for (int i = 0; i < 10; i++) {
            //1.生成10个随机数，值在100到200之间；
            int random = (int) (Math.random()*100+100);
            //2.将这十个数存入HashSet集合中
            set.add(random);
        }
        List list = new ArrayList();
        //3.将这个HashSet集合转换成ArrayList集合
        list.addAll(set);
        //4.重新为ArrayList集合排序，按照从小到大的顺序
        Collections.sort(list);
        //5.使用foreach遍历集合
        for (Object obj :
             list) {
            System.out.println(obj);
        }

    }




}
