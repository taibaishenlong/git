package com.wangchao.day1020.threetx.dao.impl;

import com.wangchao.day1020.threetx.IAccountService;
import com.wangchao.day1020.threetx.bean.Account;
import com.wangchao.day1020.threetx.dao.AccountDao;

//账户业务层实现类
public class AccountServiceImpl implements IAccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("--转账操作--");
        //根据账户姓名查询账户信息
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        //转账操作
        source.setBalance(source.getBalance() - money);
        target.setBalance(target.getBalance() + money);
        //更新操作
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
