package com.wangchao.day1019.springaop.aopanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//注解方式的AOP的测试
public class AOPAnnoTest {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("aopanno.xml");
        //获取对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //执行方法
        accountService.saveAccount();
    }
}
