package com.wangchao.day1021.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
public class HelloServlet {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello StringSpringMVC");
        return "success";
    }

}
