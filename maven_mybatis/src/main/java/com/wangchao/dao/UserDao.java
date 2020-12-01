package com.wangchao.dao;

import com.wangchao.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    @Select("select * from user")
    List<User> findUserById();
}
