package com.wangchao.day1019.jdbc.dao.impl;

import com.wangchao.day1019.jdbc.bean.Account;
import com.wangchao.day1019.jdbc.dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl2  implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //根据用户id查询用户
    @Override
    public Account findAccountById(Integer id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.isEmpty()?null:list.get(0);
    }

    //根据用户姓名查询用户
    @Override
    public Account findAccountByName(String accountName) {
        List<Account> list = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), accountName);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    //更新用户
    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name =?,balance = ? where id=?",account.getName(),account.getBalance(),account.getId());
    }
}
