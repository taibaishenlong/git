package com.wangchao.dao;

import com.wangchao.bean.Account;
import com.wangchao.bean.AccountUser;
import com.wangchao.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

//一对一
public interface AccountDao {
    /*查询所有账户，同时获取账户的所属用户名称及它的地址信息*/
    List<AccountUser> findAll();

    //使用account中添加的user对象  一对一查询  一个账户对应一个用户
    List<Account> findAllAcc();
    //一对多查询  一个用户对应多个账户
    List<User> findAllUser();

    //懒加载
    List<Account> findAllLazy();

    /*注解  查询所有账户，采用延迟加载的方式查询账户的所属用户*/
    @Select("select * from account")
    @Results(id="accountMap",
            value = {
            @Result(id=true,column = "acc_id",property = "acc_id"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "money",property = "money"),
            @Result(column = "user_id",property = "user",
            one = @One(select = "com.wangchao.dao.selectUserById",
               fetchType = FetchType.LAZY)
            )
    })
    List<Account> findAllAccountAndUser();
}
