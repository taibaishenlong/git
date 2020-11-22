package com.wangchao.day1020.onetx.dao.impl;

import com.wangchao.day1020.onetx.bean.Account;
import com.wangchao.day1020.onetx.dao.IAccountDao;
import com.wangchao.day1020.onetx.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount(){
        List<Account> list = null;
        try {
            list = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account", new BeanListHandler<Account>(Account.class)
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findAccountById(Integer id) {
        Account account = null;
        try {
            account  = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where id = ?",
                    new BeanHandler<Account>(Account.class), id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }


    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "insert into account(name,balance) values(?,?)",
                    account.getName(), account.getBalance());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name = ?,balance = ? where id = ?",account.getName(),
                    account.getBalance(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "delete  from account where id = ?",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Account findAccountByName(String name) {
        Account account = null;
        try {
            account = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name = ?", new BeanHandler<Account>(Account.class), name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
}
