package com.wangchao.day1020.threetx.dao.impl;

import com.wangchao.day1020.threetx.bean.Account;
import com.wangchao.day1020.threetx.dao.AccountDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//转账账户的持久层实现类
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        if(list.isEmpty()){
            return  null;
        }
        if(list.size() > 1){
            throw new RuntimeException("结果不唯一，");
        }
        return list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ? ,balance = ? where id = ?", account.getName(), account.getBalance(), account.getId());
    }
}
