package com.wangchao.day1021.onetx_isolation.dao.impl;

import com.wangchao.day1021.onetx_isolation.bean.Account;
import com.wangchao.day1021.onetx_isolation.dao.IAccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//持久层实现类
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{

    @Override
    public Account findAccountById(Integer id) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,balance = ? where id = ?",account.getName()
        ,account.getBalance(),account.getId());
    }
}
