package com.wangchao.day1021.onetx_isolation.service.impl;

import com.wangchao.day1021.onetx_isolation.bean.Account;
import com.wangchao.day1021.onetx_isolation.dao.IAccountDao;
import com.wangchao.day1021.onetx_isolation.service.IAccountService;

//业务层实现类
public class AccountServiceImpl implements IAccountService {
    //创建AccountDao对象
    private IAccountDao iAccountDao;

    public void setAccountDao(IAccountDao accountDao) {
        iAccountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return iAccountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("--账户转账---");
        //转账，根据账户名称查询账户信息
        Account sourceAccount = iAccountDao.findAccountByName(sourceName);
        System.out.println("sourceAccount :"+sourceAccount);
        Account targetAccount = iAccountDao.findAccountByName(targetName);
        System.out.println("targetAccount :"+targetAccount);
        //计算转账后账户金额
        sourceAccount.setBalance(sourceAccount.getBalance() - 1000f);
        targetAccount.setBalance(targetAccount.getBalance() + 1000f);
        //修改账户信息
        iAccountDao.updateAccount(sourceAccount);
        iAccountDao.updateAccount(targetAccount);
    }
}
