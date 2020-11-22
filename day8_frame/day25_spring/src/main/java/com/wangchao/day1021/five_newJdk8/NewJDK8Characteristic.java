package com.wangchao.day1021.five_newJdk8;

import com.wangchao.day1021.fourtx_service.bean.Account;
import org.junit.Test;

import java.lang.reflect.Method;

//jdk8中的一些新特性
public class NewJDK8Characteristic {
    //循环次数定义：10亿次
    private static  final int loopCnt = 1000 * 1000 * 1000;

    public static void main(String[] args) throws Exception {
        //输出jdk的版本
        System.out.println("java.version = "+System.getProperty("java.version"));
        t1();
        t2();
        t3();
    }
    //每次重新生成对象
    public static  void t1(){
        long s = System.currentTimeMillis();
        for (int i = 0 ; i < loopCnt ; i ++){
            Account account = new Account();
            account.setId(20);
        }
        long e = System.currentTimeMillis();
        System.out.println("循环10亿次创建对象的时间："+(e-s));
    }

    // 同一个对象
    public static void t2() {
        long s = System.currentTimeMillis();
        Account account = new Account();
        for (int i = 0; i < loopCnt; i++) {
            account.setId(32);
        }
        long e = System.currentTimeMillis();
        System.out.println("循环10亿次给同一对象赋值的时间： " + (e - s));
    }
    //使用反射创建对象
    public static void t3() throws Exception {
        long s = System.currentTimeMillis();
        Class<Account> c = Account.class;
        Account p = c.newInstance();
        Method m = c.getMethod("setId", Integer.class);
        for (int i = 0; i < loopCnt; i++) {
            m.invoke(p, 33);
        }
        long e = System.currentTimeMillis();
        System.out.println("循环10亿次反射创建对象的时间：" + (e - s));
    }
}
