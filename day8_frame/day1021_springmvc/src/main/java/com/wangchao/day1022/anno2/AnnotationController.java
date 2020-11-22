package com.wangchao.day1022.anno2;

import com.wangchao.day1022.param1.bean.Account;
import com.wangchao.day1022.param1.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

//控制器
@Controller
@RequestMapping(path = "/day1022/annoController")
public class AnnotationController {

    /*常用注解：RequestParam,当使用此注解时，请求上的参数可以不和方法上的参数名相同，但需要使用该注解将请求上的参数指定到方法上*/
    @RequestMapping(path = "/requestParam")
    public String  param(@RequestParam(name="name") String username){
        System.out.println("常用注解执行了。。。");
        System.out.println("username :"+username);
        return  "success";
    }

    //RequestBody请求体注解：用于获取请求体中的内容，注意请求方式不能是get请求，且方法上形参和请求体中的name不能一致
    @RequestMapping(path = "/requestBody")
    public String beanGetReference(@RequestBody String  body){
        System.out.println("RequestBody请求体注解");
        System.out.println("body : "+body);
        return "success";
    }
    //Pathvariable:拥有绑定url中的占位符，url中有/delete/{id}，{id}就是占位符
    @RequestMapping(path = "/pathvariable/{sid}")
    public String pathvariable(@PathVariable(name = "sid") String  id){
        System.out.println("Pathvariable请求体注解");
        System.out.println("id : "+id);
        return "success";
    }

    //RequestHeader:拥有绑定url中的占位符，url中有/delete/{id}，{id}就是占位符
    @RequestMapping(path = "/requestHeader")
    public String requestHeader(@RequestHeader(name = "Accept") String  id){
        System.out.println("RequestHeader请求体注解");
        System.out.println("id : "+id);
        return "success";
    }

    //CookieValue:用于获取指定Cookie名称的值
    @RequestMapping(path = "/cookieValue")
    public String cookieValue(@CookieValue(name = "JSESSIONID") String  cookie){
        System.out.println("CookieValue请求体注解");
        System.out.println("cookie : "+cookie);
        return "success";
    }

    //1、MOdelAttribute:出现在方法上，表示优先于控制器方法先执行  修饰的方法带有返回值类型user
    @ModelAttribute
    public User showUser(String username,Integer age){
        System.out.println("modelAttribute修饰的方法优先于控制器执行");
        //模拟查询用户信息，页面上没有提交的信息继续使用数据库中的原数据
        User user = new User();
        user.setName(username);
        user.setAge(age);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping(path = "/modelAttribute")
    public String modelAttribute(User user){
        System.out.println("user : "+user);
        return "success";
    }

    //2、ModelAttribute：修饰的方法上没有返回值
    @ModelAttribute
    public void showUser(String username,Integer age, Map<String,User> map){
        //创建User对象
        User user = new User();
        user.setName(username);
        user.setAge(age);
        user.setDate(new Date());
        map.put("abc",user);
    }

    //将modelAttribute放到参数上进行修饰，将指定值赋值给参数
    @RequestMapping(path = "/modelAttribute2")
    public String modelAttribute2(@ModelAttribute(name = "abc")User user){
        System.out.println(user);
        return "success";
    }

}
