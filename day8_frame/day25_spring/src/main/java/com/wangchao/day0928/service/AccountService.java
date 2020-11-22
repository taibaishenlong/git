package com.wangchao.day0928.service;

import com.wangchao.day0928.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有
    List<Account> findAll();

    //根据id查询一个
    Account findAccountById(Integer id);

    //保存
    void saveAccount(Account account);

    //根据id删除
    void deleteAccount(Integer id);

    //修改
    void updateAccount(Account account);
}
