package com.atguigu.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 10.按要求实现下列问题：
 1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；（10分）

 2)只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
 新闻二：春节临近北京“卖房热”

 3)将新闻对象添加到ArrayList集合中，并且使用ListIterator倒序遍历；

 4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前14个，然后在后边加“…”

 5)在控制台打印遍历出经过处理的新闻标题；

 *
 */
public class News {

    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}

class NewsTest{
    public static void main(String[] args) {
        News news1 = new News("中国多地遭雾霾笼罩空气质量再成热议话题");
        News news2 = new News("春节临近北京卖房热");


        //将新闻对象添加到ArrayList集合中
        ArrayList<News> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);
        //方式一：可以使用空参构造器，则此时指针的位置指向了第一个元素的前一位
//        ListIterator<News> listIterator = list.listIterator();
//        while (listIterator.hasNext()){
//            listIterator.next();
//        }
        int size = list.size();
        //创建一个一开始就指向列表索引为n的元素处的ListIterator
        ListIterator<News> listIterator = list.listIterator(size);
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        //在正序遍历集合的时候对标题进行修改
        Iterator<News> iterator = list.iterator();
        while (iterator.hasNext()){
            //这里有坑，需要把指针指向的对象定义为变量
            News news = iterator.next();
            if(news.getTitle().length() <= 15){
                System.out.println(news.getTitle());
            }else {
                System.out.println(news.getTitle().substring(0,14) + "...");
            }

        }


    }
}
