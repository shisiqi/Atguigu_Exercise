package com.atguigu.java2;

/**
 * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值
 */
public class ValueTransferTest2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("m=" + data.m +",n="+ data.n);//m=10,n=20

        //使用方法完成m,n变量值的交换
        ValueTransferTest2 valueTransferTest2 = new ValueTransferTest2();
        valueTransferTest2.swap(data);
        System.out.println("m=" + data.m +",n="+ data.n);//m=20,n=10

    }
    public void swap(Data data){
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data{
    int m;
    int n;
}
