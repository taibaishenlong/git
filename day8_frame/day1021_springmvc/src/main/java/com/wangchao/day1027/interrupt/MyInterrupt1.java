package com.wangchao.day1027.interrupt;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截器1  要实现HandlerInterrupt接口，并可重写三个方法
public class MyInterrupt1 implements HandlerInterceptor {
    /**
     * controller方法执行前执行的拦截方法，
     *
     * @param request
     * @param response
     * @param handler  return  true :放行
     *                 return false :拦截
     *                 可以使用转发或重定向直接跳转到指定页面
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了Controller处理器中方法......前");
        return true;//放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了Controller处理器方法......后，跳转页面...前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("success.jsp页面执行后执行....后");
    }
}