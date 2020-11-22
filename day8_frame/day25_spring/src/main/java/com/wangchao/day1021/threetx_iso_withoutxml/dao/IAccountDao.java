package com.wangchao.day1021.threetx_iso_withoutxml.dao;

import com.wangchao.day1021.threetx_iso_withoutxml.bean.Account;

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
