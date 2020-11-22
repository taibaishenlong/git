package com.wangchao.day1027.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/day1027/my")
public class MyController {

    @RequestMapping(path = "/intercept")
    public String testInterrupt(){
        System.out.println("testInterrupt执行了.......");
        /*int i = 89/0;           //在此构造一个算术异常，会引发异常处理
        System.out.println("i : "+i);*/
        return "success";
    }
}
