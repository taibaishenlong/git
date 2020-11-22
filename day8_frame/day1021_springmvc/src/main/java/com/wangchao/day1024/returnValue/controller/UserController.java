package com.wangchao.day1024.returnValue.controller;

import com.wangchao.day1024.returnValue.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/day1024/user")
public class UserController {

    @RequestMapping(path = "/returnString")
    public String returnStringValue(Model model){
        //模拟向数据库中存值，并在页面上获取该值
        User user = new User();
        user.setUsername("中正");
        user.setAge(30);
        user.setPassword("5656");
        //将值存入到域对象中
        model.addAttribute("user",user);
        return "returnValue";
    }

    //当返回值类型为void时，默认跳转到retrnVoid.jsp页面，如果没有该页面，报404错误
    @RequestMapping(path = "/returnVoid")
    public void requestVoidValue(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("返回值为void的方法执行 ");
        //请求转发到页面success.jsp页面
       // request.getRequestDispatcher("/WEB-INF/day21/success.jsp").forward(request,response);
        //重定向到success.jsp页面
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //直接响应内容
        //先处理乱码问题
         response.setCharacterEncoding("UTF-8");
        //设置浏览器响应编码
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你好吗");
        return ;//如果不让继续执行后续代码，返回return
    }

    @RequestMapping(path = "/returnModelAndView")
    public ModelAndView returnModelAndView(){
        //创建MoldeAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("returnValue");
        //模拟向数据库中查询数据
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("李白");
        user1.setAge(21);
        user1.setPassword("2222");

        User user2 = new User();
        user2.setUsername("杜甫");
        user2.setPassword("3333");
        user2.setAge(30);
        users.add(user1);
        users.add(user2);
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    /*spring框架为我们提供了专门的请求转发工具，
    * 使用关键字forward关键字进行请求转发
    * forward：转发的jsp路径，不走视图解析器，所以需要编写完整的路径
    * */
    @RequestMapping(path = "/forward")
    public String spring_forward(){
        System.out.println("spring框架转发提供的forward关键字");
        return "forward:/day1024/user/returnModelAndView";
        //return "forward:/WEB-INF/day21/get.jsp";
    }

    @RequestMapping(path = "/redirect")
    public String spring_redirect(){
        System.out.println("spring框架提供的重定向关键字redirect");
        //return "redirect:/index.jsp";
        //return  "redirect:../../WEB-INF/day21/get.jsp";          错误
          return "redirect:/day1024/user/returnModelAndView";
    }

    //获取json串发送的数据
    @RequestMapping(path = "/testAjax")
    public String testJson(@RequestBody String body){
        System.out.println("body :"+body);
        return "success";
    }

    //使用@RequestBody注解将json串转化为javaBean对象
    @RequestMapping(path = "/testJsonTojavaBean")
    public void jsonToJavaBean(@RequestBody User user){
        System.out.println("user : "+user);
    }

    //使用@RequestBody注解将javaBean对象转换成json串
    @RequestMapping(path = "/testJavaBeanToJson")
    public @ResponseBody User javaBeanToJson(@RequestBody User user){
        System.out.println("user :"+user);
        user.setUsername("阿郎");
        return user;
    }
}
