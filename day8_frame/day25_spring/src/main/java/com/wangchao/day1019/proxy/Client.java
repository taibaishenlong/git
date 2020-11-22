package com.wangchao.day1019.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //一个剧组找演员
        final  Actor actor = new Actor();//直接
        /*
          代理间接
         */
        IActor proxyActor = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        Float money = (Float) args[0];
                        Object rtValue = null;
                        if ("basicAct".equals(name)) {
                            //基本演出，没有2000不接
                            if (money > 2000) {
                                rtValue = method.invoke(actor, money / 2);
                            }
                        }
                        if ("dangerAct".equals(name)) {
                            //危险演出，没有5000不接
                            if (money > 5000) {
                                rtValue = method.invoke(actor, money / 2);
                            }
                        }
                        System.out.println("rtValue :"+rtValue);
                        return rtValue;
                    }
                });
        //剧组无法直接联系演员，而是由经纪公司找的演员
        proxyActor.basicAct(8000);
        proxyActor.dangerAct(12000);
    }
}
