package com.wangchao.day1019.proxy;
/*
表演者接口，被代理的类最少实现一个接口
本接口提供两个方法，基本演出和危险表演
 */
public interface IActor {
    //基本演出
    public void basicAct(float money);
    //危险演出
    public void dangerAct(float money);
}
