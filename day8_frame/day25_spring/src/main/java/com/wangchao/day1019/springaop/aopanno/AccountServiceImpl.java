package com.wangchao.day1019.springaop.aopanno;

import org.springframework.stereotype.Service;

//账户的业务层实现类  使用注解方式
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存操作");
    }

    @Override
    public void updateAccount(int i) {
//        int k = i/0;
        System.out.println("执行了更新操作 ： "+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除操作...");
        return 0;
    }
}
