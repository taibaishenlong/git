package com.wangchao.day1020.twotx_anno.dao.impl;

import com.wangchao.day1020.twotx_anno.bean.Account;
import com.wangchao.day1020.twotx_anno.dao.IAccountDao;
import com.wangchao.day1020.twotx_anno.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

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
        List<Account> list = null ;
        try {
           list  = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name = ?", new BeanListHandler<Account>(Account.class), name);
            //如果有结果 就返回
            if(list == null && list.size() == 0){
                return null;
            }
            if(list.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list.get(0);
    }
}
