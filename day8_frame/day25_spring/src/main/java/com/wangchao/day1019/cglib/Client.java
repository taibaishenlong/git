package com.wangchao.day1019.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    /*
    基于子类的动态代理
    要求：被代理的对象不能是最终类
    要到的方法：create(Class,Callback)
    方法的参数：Class:被代理对象的字节码
              Callback:如何代理
     */
    public static void main(String[] args) {
        final Actor actor = new Actor();
        Actor cglibactor = (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
               //执行被代理对象的任何方法，都会经过该方法。在此方法内部就可以对被代理对象的任何方法进行增强
                String name = method.getName();
                Float money = (Float)args[0];
                Object rtValue  = null ;
                if ("basicAct".equals(name)) {
                    //基本演出
                    if(money>2000){
                        rtValue = method.invoke(actor, money / 2);
                    }
                }
                if ("dangerAct".equals(name)) {
                    if(money>5000){
                        rtValue = method.invoke(actor,money/2);
                    }
                }

                return rtValue;
            }
        });
        cglibactor.basicAct(9000);
        cglibactor.dangerAct(15000);
    }
}
