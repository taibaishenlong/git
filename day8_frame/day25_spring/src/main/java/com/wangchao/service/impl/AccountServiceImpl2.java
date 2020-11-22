package com.wangchao.service.impl;

import com.wangchao.dao.AccountDao;
import com.wangchao.dao.impl.AccountDaoImpl;
import com.wangchao.service.AccountService2;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService2 {
    private AccountDao accountDao = new AccountDaoImpl();
    //依赖注入 属性
    private String name;
    private Integer age;
    private Date birthday;

    //使用set方法依赖注入

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println(name+" : "+age+" : "+birthday);
        accountDao.saveAccount();
    }
}
