package com.wangchao.day1020.threetx.dao;

import com.wangchao.day1020.threetx.bean.Account;

//转账账户持久层接口
public interface AccountDao {
    //根据id查询账户
    Account findAccountById(Integer id);
    //根据名称查询账户
    Account findAccountByName(String name);
    //更新账户
    void updateAccount(Account account);
}
