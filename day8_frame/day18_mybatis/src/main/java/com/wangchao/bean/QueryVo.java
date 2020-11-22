package com.wangchao.bean;

import java.util.List;

//将user对象封装起来
public class QueryVo {
    private User user;
    private List<Integer> list ;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
