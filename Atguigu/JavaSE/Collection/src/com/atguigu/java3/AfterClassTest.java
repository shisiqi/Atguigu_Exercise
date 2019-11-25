package com.atguigu.java3;

import org.junit.Test;

import java.util.*;

/**
 * 课后练习：
 *  1.请从键盘随机输入10个整数保存到List中，并按倒序、从大 到小的顺序显示出来
 */
public class AfterClassTest {

    @Test
    public void test1(){
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请随机输入10个整数");
        for (int i = 0; i < 10; i++) {
            int num = scanner.nextInt();
            list.add(num);
        }

        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1,i2);
                }
                throw new RuntimeException("输入数据的类型不匹配");
            }
        });
    }
}
