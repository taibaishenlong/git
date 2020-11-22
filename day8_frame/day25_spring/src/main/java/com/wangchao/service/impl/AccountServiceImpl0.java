package com.wangchao.service.impl;

import com.wangchao.dao.AccountDao;
import com.wangchao.factory.BeanFactory;
import com.wangchao.service.AccountService0;

public class AccountServiceImpl0 implements AccountService0 {
         private final AccountDao accountDao ;

    public AccountServiceImpl0(AccountDao accountDao) {
        this.accountDao = (AccountDao)BeanFactory.getBean("accountDao");
    }

    //创建dao对象
    /* private AccountDao accountDao = new AccountDaoImpl();*/
    @Override
    public void saveAccount() {
//        AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
//        AccountDao accountDao2 = (AccountDao) BeanFactory.getBean("accountDao");
        int i = 1;
        System.out.println(i);
        System.out.println(accountDao);
//        System.out.println(accountDao2==accountDao);
        accountDao.saveAccount();
        i++;
    }
}
