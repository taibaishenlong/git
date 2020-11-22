package com.wangchao.day1019.jdbc.dao;

import com.wangchao.day1019.jdbc.bean.Account;

//账户持久层接口
public interface AccountDao {
    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
