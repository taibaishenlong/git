package com.wangchao.day1022.param1.controller;

import com.wangchao.day1022.param1.bean.Account;
import com.wangchao.day1022.param1.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//控制器
@Controller
@RequestMapping(path = "/day1022/paramController")
public class ParameterController {

    /*基本数据类型绑定*/
    @RequestMapping(path = "/param")
    public String  param(String username,String password){
        System.out.println("执行了。。。");
        System.out.println("username :"+username);
        System.out.println("password :"+password);
        return  "success";
    }

    //引用数据类型绑定
    @RequestMapping(path = "/getReferenceType")
    public String beanGetReference(Account account){
        System.out.println("引用类型绑定");
        System.out.println("account : "+account);
        return "success";
    }

    //绑定集合数据类型
    @RequestMapping(path = "/getCollection")
    public String getCollection(Account account){
        System.out.println("集合数据类型绑定");
        System.out.println("account : "+account);
        return "success";
    }
    //字符串类型转化为日期类型
    @RequestMapping(path = "/stringToDate")
    public String stringToDate(User user){
        System.out.println("数据类型转换了");
        System.out.println("user : "+user);
        return "success";
    }
    //字符串类型转化为日期类型
    @RequestMapping(path = "/getServletAPI")
    public String getServletAPI(HttpServletRequest request, HttpServletResponse  response){
        System.out.println("获取原生ServletAPI....");
        System.out.println("request : "+request);
        //获取session
        HttpSession session = request.getSession();
        System.out.println("session :"+session);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext : "+servletContext);
        System.out.println("response : "+response);
        return "success";
    }

}
