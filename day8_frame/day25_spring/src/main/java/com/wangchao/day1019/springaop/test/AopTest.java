package com.wangchao.day1019.springaop.test;

import com.wangchao.day1019.springaop.dao.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试AOP的配置
public class AopTest {
    public static void main(String[] args) {
      //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        //执行方法
        accountService.saveAccount();
        accountService.updateAccount(2);
        accountService.deleteAccount();
    }
}
