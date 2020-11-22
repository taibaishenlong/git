package com.wangchao.bean;

import java.io.Serializable;

public class Account  implements Serializable {
    private Integer acc_id;
    private Integer user_id;
    private double money;

    //添加User对象 证明此账号是属于哪个用户 一对一查询  一个账户对应一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account() {
    }

    public Account(Integer acc_id, Integer user_id, double money) {
        this.acc_id = acc_id;
        this.user_id = user_id;
        this.money = money;
    }

    public Integer getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_id=" + acc_id +
                ", user_id=" + user_id +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
