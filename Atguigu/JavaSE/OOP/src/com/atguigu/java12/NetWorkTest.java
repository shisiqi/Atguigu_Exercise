package com.atguigu.java12;

/**
 *
 * 代理模式：
 *  静态代理：造一个代理类的对象，但是创建代理类对象的时候
 *  需要把被代理对象作为参数传入代理对象的构造器中
 *  在形式上，都是代理对象去帮助被代理对象完成，
 *  但是有些方法被代理对象搞不定，还得去调用代理对象去执行方法
 *  比如这里形式上是代理对象调用browse方法，
 *  实际browse方法中还是去调用被代理对象的browse方法，
 *  只不过对外暴露的是代理对象而不是被代理对象，一旦代理对象
 *  需要被代理对象了，就会调用你"被代理对象"去完成某个方法的调用
 *
 *  但是某些"杂活、脏活、累活"，不需要被代理对象来干，代理对象也能干，
 *  那就代理对象自己完成即可；比如说这个案例中，在真实的服务器访问网络之前
 *  需要代理对象先做好前置任务（或者说铺垫工作），于是调用ProxyServer的check方法
 *  完成了"联网之前的检查工作"
 */
public class NetWorkTest {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}
interface NetWork{
    void browse();
}

//被代理类
class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

class ProxyServer implements NetWork{

    private NetWork netWork;


    /*
    构造器这边声明的是传入一个NetWork，
    其实真正需要传入的是实现类-->Server，这里体现了多态
    父类引用指向子类对象
     */
    public ProxyServer(NetWork netWork) {
        this.netWork = netWork;
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }
    @Override
    public void browse() {
        check();
        netWork.browse();
    }
}
