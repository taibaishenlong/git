package com.wangchao.day1020.onetx.service;

import com.wangchao.day1020.onetx.bean.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    //查询所有
    List<Account> findAllAccount();
    //查询一个
    Account findAccountById(Integer id);
    //保存
    void saveAccount(Account account);
    //更新
    void updateAccount(Account account);
    //删除
    void deleteAccount(Integer id);

    /**
     * 转账
     * @param sourceName  转出账户名称
     * @param targetName  转入账户名称
     * @param money       转账金额
     */
    void transfer(String sourceName,String targetName,float money);

    //void test();  //他只是连接点，但不是切入点，应为没有被增强
}
