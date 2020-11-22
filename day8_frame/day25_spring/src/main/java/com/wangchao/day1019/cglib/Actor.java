package com.wangchao.day1019.cglib;

/*
 基于子类的动态代理
 提供者：第三方的CGLib,如果包axmxxxx异常，需要导入asm.jar
 要求：被代理的类不能用final修饰的类(最终类)
 不实现任何接口
 */
public class Actor {
    public  void basicAct(float money){
        System.out.println("拿到钱，就开始基础表演 ："+money);
    }
    public void dangerAct(float money){
        System.out.println("拿到钱，就开始危险表演 ："+money);
    }
}
