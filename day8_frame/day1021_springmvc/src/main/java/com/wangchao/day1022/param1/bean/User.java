package com.wangchao.day1022.param1.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private Integer age;

    //表单提交的任何数据类型都是字符串类型，
    // 但后台定义的Integer类型，数据也可以封装，
    // 说明Spring框架内部会默认进行数据类型转换
    //如果想要自定义数据类型转化，可以实现Converter接口
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
