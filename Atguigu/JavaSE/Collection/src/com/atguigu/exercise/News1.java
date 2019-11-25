package com.atguigu.exercise;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 15.封装一个新闻类，包含标题、作者、新闻内容和发布时间，新闻标题如下：
 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
 新闻二：民进党台北举行“火大游行”
 新闻三：春节临近北京“卖房热”
 新闻四：春节临近北京“卖房热”
 完成如下要求（共50分，每小题10分）：
 1）完成对新闻类的设计，要求在初始化新闻类对象时 ，通过构造传参的形式对新闻标题赋值，并要求实例化四个对象，标题内容如题。
 2）要求打印新闻对象时，直接打印新闻标题；
 3）要求使用equals方法比较新闻时，只要标题相同，就认为是同一新闻，请输出新闻一与新闻二的比较结果，新闻三与新闻四的比较结果。
 4）将新闻对象存入HashSet集合中，并且遍历集合，打印新闻类对象；
 5）打印集合中新闻数量。

 */
public class News1 {
    private String title;
    private String author;
    private String content;
    private Date date;


    //1)要求在初始化新闻类对象时 ，通过构造传参的形式对新闻标题赋值
    public News1(String title) {
        this.title = title;
    }


    //2)要求打印新闻对象时，直接打印新闻标题
    //重写toString的时候不打印对象的地址值，改为打印新闻标题
    @Override
    public String toString() {
        return  title ;
    }


    //3)要求使用equals方法比较新闻时，
    // 只要标题相同，就认为是同一新闻，请输出新闻一与新闻二的比较结果，新闻三与新闻四的比较结果。

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News1 news1 = (News1) o;

        return title != null ? title.equals(news1.title) : news1.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
class News1Test{
    public static void main(String[] args) {
        //1)实例化4个新闻类对象
        News1 news1 = new News1("中国多地遭雾霾笼罩空气质量再成热议话题");
        News1 news2 = new News1("民进党台北举行“火大游行”");
        News1 news3 = new News1("春节临近北京“卖房热”");
        News1 news4 = new News1("春节临近北京“卖房热”");

        System.out.println(news1);//中国多地遭雾霾笼罩空气质量再成热议话题
        System.out.println(news1.equals(news2));//false
        System.out.println(news3.equals(news4));//true

        //4）将新闻对象存入HashSet集合中，并且遍历集合，打印新闻类对象；
        //Set集合中不能存储重复对象
        //在Set集合如何判断两元素是否是同一对象？重写元素所在类的equals方法和hashCode方法
        HashSet set = new HashSet();
        set.add(news1);
        set.add(news2);
        set.add(news3);
        set.add(news4);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
            /*
            春节临近北京“卖房热”
            民进党台北举行“火大游行”
            中国多地遭雾霾笼罩空气质量再成热议话题
             */
        }
        System.out.println(set.size());//3

    }
}
