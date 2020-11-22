package com.wangchao.day1021.threetx_iso_withoutxml.dao.impl;

import com.wangchao.day1021.threetx_iso_withoutxml.bean.Account;
import com.wangchao.day1021.threetx_iso_withoutxml.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//持久层实现类
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findAccountById(Integer id) {
        List<Account> list =jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?,balance = ? where id = ?",account.getName()
        ,account.getBalance(),account.getId());
    }
}
