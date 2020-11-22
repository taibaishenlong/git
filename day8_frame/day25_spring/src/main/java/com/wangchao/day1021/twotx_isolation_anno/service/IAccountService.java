package com.wangchao.day1021.twotx_isolation_anno.service;

import com.wangchao.day1021.twotx_isolation_anno.bean.Account;

//账户转账业务层接口
public interface IAccountService {
    //根据id查询账户信息
    Account findAccountById(Integer id);
    //转账操作
    void transfer(String sourceName,String targetName,Float money);
}
