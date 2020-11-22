package com.wangchao.service.impl;


import com.wangchao.dao.AccountDao;
import com.wangchao.service.AccountService4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("accountService4")
//@Scope(value = "singleton")  //singleton :单例  prototype:多例
public class AccountServiceImpl4 implements AccountService4 {
    /*
    Autowired注解  可以在方法上或属性上进行注解，自动类型匹配
    @Qualifier不可单独使用，需搭配@Autowired使用
     */
//    @Autowired
//    @Qualifier(value = "accountDao1")
    @Resource(name = "accountDao1")
    private AccountDao accountDao ;

    @PostConstruct
    public void init_method(){
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void  destory_method(){
        System.out.println("销毁方法");
    }

    @Override
    public void saveAccount() {
        System.out.println("accountDao :"+accountDao);
        accountDao.saveAccount();
    }
}
