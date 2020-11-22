package com.wangchao.service.impl;

import com.wangchao.dao.AccountDao;
import com.wangchao.dao.impl.AccountDaoImpl;
import com.wangchao.service.AccountService2;
import com.wangchao.service.AccountService3;

import java.util.*;

public class AccountServiceImpl3 implements AccountService3 {
    private AccountDao accountDao = new AccountDaoImpl();
    //依赖注入 属性
    private String[] myst;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    //使用set方法依赖注入


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setMyst(String[] myst) {
        this.myst = myst;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(myst));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
        accountDao.saveAccount();
    }
}
