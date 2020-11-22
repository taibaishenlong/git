package com.wangchao.day1021.twotx_isolation_anno.dao;

import com.wangchao.day1021.twotx_isolation_anno.bean.Account;

/**
 * 持久层接口
 */
public interface IAccountDao {
    //根据id查询账户信息
    Account findAccountById(Integer id);
    //根据名称查询账户信息
    Account findAccountByName(String name);
    //修改账户信息
    void updateAccount(Account account);
}
