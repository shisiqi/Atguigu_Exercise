package com.atguigu.java3;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    //向TreeMap中添加key-value,要求key必须是同一个类创建的对象
    //因为要按照key进行排序：自然排序和定制排序


    @Test
    public void test1(){
        /*
        自然排序
         */
        //创建TreeMap集合
        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",24);
        User u3 = new User("Jack",34);
        User u4 = new User("Rose",45);
        map.put(u1,98);
        map.put(u2,83);
        map.put(u3,65);
        map.put(u4,78);

        //遍历map集合
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


    @Test
    public void test2(){
        /*
          定制排序
         */
        //按照年龄从小到大
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return -user1.compareTo(user2);
                }

                throw new RuntimeException("输入的类型不匹配");
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",24);
        User u3 = new User("Jack",34);
        User u4 = new User("Rose",45);
        map.put(u1,98);
        map.put(u2,83);
        map.put(u3,65);
        map.put(u4,78);

        //遍历map集合
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
class User implements Comparable{
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }


    //按照年龄从大到小排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o;
            if (this.age > user.age){
                return -1;//重写的compareTo方法返回负数则从大到小排序
            }else if (this.age < user.age){
                return 1;//重写的compareTo方法返回正数则从小到大排序
            }
            return 0;
        }
        throw new RuntimeException("输入的类型不一致");
    }
}
