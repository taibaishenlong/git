package com.wangchao.test;

import com.wangchao.day0804.domain.Account;
import com.wangchao.day0804.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//测试类
public class IOCAccountTest {
    static AccountService accountService;
    static {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocbean.xml");
        //获取accountService对象
        accountService = applicationContext.getBean("accountService", AccountService.class);
    }
    //测试查询全部的方法
    @Test
    public void  testQueryAll(){
        //调用方法
        List<Account> list = accountService.findAll();
        //遍历
        for (Account account:list) {
            System.out.println(account);
        }
    }

    //测试根据id查询
    @Test
    public void testQueryById(){
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
    //测试添加账户
    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("王昭君");
        account.setBalance(3489.05);
        accountService.saveAccount(account);
    }

    //测试删除用户的方法
    @Test
    public void testDeleteAccount(){
        accountService.deleteAccount(4);
    }

    //测试修改用户的方法
    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        account.setId(1);
        account.setName("虞姬");
        account.setBalance(8453.99);
        accountService.updateAccount(account);
    }
}
