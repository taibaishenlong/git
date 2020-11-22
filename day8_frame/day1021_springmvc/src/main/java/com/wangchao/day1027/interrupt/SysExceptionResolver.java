package com.wangchao.day1027.interrupt;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        SysException ex = null ;
        //获取到异常对象
        if(e instanceof  SysException){
            ex = (SysException)e;
        }else {
            ex = new SysException("请联系管理员");
        }
        ModelAndView mv = new ModelAndView();
        //存入错误的提示信息
        mv.addObject("message",ex.getMessage());
        //跳转到jsp页面
        mv.setViewName("error");
        return mv;
    }
}
