package com.wangchao.day1020.onetx.dao;

import com.wangchao.day1020.onetx.bean.Account;

import java.util.List;

//账户的持久层接口
public interface IAccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户信息
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 修改账户信息
     * @param account
     */
    void updateAccount(Account account);
    /**
     * 根据id删除账户信息
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据账户名称查询账户信息
     * @param name
     * @return 如果有唯一一个结果就返回，如果没有结果就返回null
     * 如果结果集超过一个就抛出异常
     */
    Account findAccountByName(String name);
}
