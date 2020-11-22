package com.wangchao.day1019.proxy;
//定义演员类  实现了接口，就表示具有了接口中的方法实现
/*
基于接口的动态代理：
提供者：JDK的Proxy类
要求：被代理类最少实现一个接口。
 */
public class Actor implements  IActor {
    @Override
    public void basicAct(float money) {
        System.out.println("拿到钱，就开始基本表演 ："+money);

    }

    @Override
    public void dangerAct(float money) {
        System.out.println("拿到钱，就开始危险表演 ："+money);
    }
}
