package com.wangchao.day1021.twotx_isolation_anno.service.impl;

import com.wangchao.day1021.twotx_isolation_anno.bean.Account;
import com.wangchao.day1021.twotx_isolation_anno.dao.IAccountDao;
import com.wangchao.day1021.twotx_isolation_anno.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//业务层实现类
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements IAccountService {
    //创建AccountDao对象
    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public Account findAccountById(Integer id) {
        return iAccountDao.findAccountById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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
