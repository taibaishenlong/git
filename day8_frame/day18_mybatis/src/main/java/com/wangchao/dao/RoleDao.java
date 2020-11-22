package com.wangchao.dao;

import com.wangchao.bean.Role;
import com.wangchao.bean.User;

import java.util.List;

public interface RoleDao {
    //查询所有角色  实现的是role到user的多对多
    List<Role> findAllRole();
    //查询所有用户  实现的是user到role的多对多
    List<User> findAllUser();

}
