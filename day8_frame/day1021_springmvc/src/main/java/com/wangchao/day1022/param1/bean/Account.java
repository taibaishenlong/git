package com.wangchao.day1022.param1.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    /*绑定基本数据类型*/
    private  Integer id;
    private  String name;
    private  Float balance;

    /*绑定引用数据类型*/
    //private User user;

    //绑定复杂数据类型，list和map集合
    private List<User> list;

    private Map<String,User> map;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }*/

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
