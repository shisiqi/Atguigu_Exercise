package com.atguigu.java4;

/**
 * this关键字的使用：
 *  1.this可用来修饰：属性、方法和构造器
 *  2.this修饰属性和方法：
 *      this理解为：当前对象
 *      在类的方法中我们可以使用"this.属性"和"this.方法"的方式调用当前对象的属性和方法
 *      但是通常情况下都省略this. ;但是当方法的形参和类的成员变量（属性）同名时，我们
 *      必须显式地使用this.成员变量地方式，表示此变量是属性，而非形参
 *
 *  3.this调用构造器
 *      1）我们在类的构造器中，可以显式地使用“this(形参列表)”方式，调用本类中的其他构造器
 *      2）构造器中不能通过“this(形参列表)”方式调用自己
 *      3）如果一个类中有n个构造器，则最多有n-1个构造器中使用了“this（形参列表）”
 *      4）规定：this(形参列表)必须声明在当前构造器首行
 *      5）构造器内部，最多只能声明一个“this(形参列表)”，用来调用其他构造器
 *
 *
 *      我们用一个构造器去调用另外一个构造器，主要是为了把对象初始化的一些冗余代码，
 *      单独写在一个构造器中，然后用其他构造器去调用该构造器，也能执行到这些对象初始化的代码，
 *      这样写显得更加简洁。
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();

        p1.setAge(3);
        System.out.println(p1.getAge());//3

        p1.eat();//人吃饭 人学习

        System.out.println("************************");

        Person p2 = new Person("jerry",20);

    }
}

class Person{

    private String name;
    private int age;

    public Person() {
        this.eat();
        String info = "Person初始化时，需要考虑以下的1,2,3,4...";
        System.out.println(info);
    }

    public Person(int age) {
        this();//调用空参构造器
        this.age = age;
    }

    public Person(String name, int age) {
        this(age);//调用有参构造器
        this.name = name;
        //this.age = age;
    }

    public void setName(String name){
        //name = n;
        //若把形参中的变量名改成name,为了防止name = name的就近原则
        // （此时等号左右两边的变量都会把自己当成是形参name）
        // 使用this关键字区分成员变量(属性)和局部变量
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        //age = a;
        this.age = age;
    }

    public int getAge(){
        return age;//return this.age; 省略了this.
    }

    public void eat(){
        System.out.println("人吃饭");
        study();//this.study()省略了this.
    }

    public void study(){
        System.out.println("人学习");
    }

}
