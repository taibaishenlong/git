package com.wangchao.day1020.threetx;

import com.wangchao.day1020.threetx.bean.Account;

//转账业务层
public interface IAccountService {
    //根据账户姓名查询账户信息
    Account findAccountById(Integer id);
    //转账
    void transfer(String sourceName,String targetName,Float money);
}
