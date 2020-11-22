package com.wangchao.day1022.anno2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


//控制器
@Controller
@RequestMapping(path = "/day1022/annoController2")
@SessionAttributes(value = {"msg"})     //向session中存入数据
public class AnnotationController2 {

    @RequestMapping(path = "/setsessionAttributes")
    public String setsessionAttributes(Model model){
        //底层存储到request域对象
        model.addAttribute("msg","妹妹好");
        return "get";
    }
    @RequestMapping(path = "/getsessionAttributes")
    public String getsessionAttributes(ModelMap modelMap){
        //获取所设置的共享值
        String  msg = (String) modelMap.get("msg");
        System.out.println("msg : "+msg);
        return "get";
    }
    @RequestMapping(path = "/delsessionAttributes")
    public String delsessionAttributes(SessionStatus status){
        //将值清除
        status.setComplete();
        return "get";
    }

}
