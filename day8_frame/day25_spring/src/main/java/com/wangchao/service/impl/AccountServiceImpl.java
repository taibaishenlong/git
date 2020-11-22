package com.wangchao.service.impl;

import com.wangchao.dao.AccountDao;
import com.wangchao.factory.BeanFactory;
import com.wangchao.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("acountDao");
    //依赖注入 属性
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl() {
    }
    //使用构造函数依赖注入
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    //创建dao对象
   /* private AccountDao accountDao = new AccountDaoImpl();*/
    @Override
    public void saveAccount() {
         int i = 1;
        /*System.out.println(name+" : "+age+" : "+birthday);*/
        System.out.println(i);
        System.out.println(accountDao);
        accountDao.saveAccount();
        i++;
    }
}
