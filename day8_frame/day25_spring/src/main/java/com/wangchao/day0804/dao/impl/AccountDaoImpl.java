package com.wangchao.day0804.dao.impl;

import com.wangchao.day0804.dao.AccountDao;
import com.wangchao.day0804.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
//账户的持久层实现类
@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "runner")
  private QueryRunner queryRunner;

    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = null;
        try {
            list  = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findAccountById(Integer id) {
        Account account = null;
        try {
          account = queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,balance) value(?,?)",account.getName(),account.getBalance());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            queryRunner.update("delete from account where id = ? ",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=? ,balance = ? where id = ?",account.getName(),account.getBalance(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
