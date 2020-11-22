<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2020/10/21
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <%--常用注解--%>
    <h4>注解RequestParam：把请求中的指定名称的参数传递给控制器中的形参赋值</h4>
    <a href="annoController/requestParam?name=李白">常用注解RequestParam</a>
    <br/><br/>
    <%--注解RequestBody--%>
    <h4>注解RequestBody:获取请求体中的内容，不能使用get请求，因为get请求是没有请求体的，直接在超链接上的</h4>
    <form action="annoController/requestBody" method="post">
        姓名：<input type="text" name="username"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交">
    </form>
    <br/><br/>
    <h4>注解Pathvariable：拥有绑定url中的占位符</h4>
    <a href="annoController/pathvariable/10">常用注解Pathvariable</a>

    <br/><br/>
    <h4>注解RequestHeader:获取指定头的值</h4>
    <a href="annoController/requestHeader">常用注解RequestHeader</a>
    <br/><br/>
    <h4>注解CookieValue:用于获取指定Cookie名称的值</h4>
    <a href="annoController/cookieValue">常用注解CookieValue</a>

    <h4>注解ModelAttribute:1、当出现在方法上时，表示当前方法优先于控制器方法先执行
        2、出现在参数上，表示获取指定的数据给参数赋值</h4>
    <form action="annoController/modelAttribute" method="post">
        姓名：<input type="text" name="username"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交">
    </form>

    <br/><br/>
    <form action="annoController/modelAttribute2" method="post">
        姓名：<input type="text" name="username"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交">
    </form>
    <br/><br/><hr/>
    <%--SessionAttributes:用于多次执行控制器方法间参数的共享--%>
    <a href="annoController2/setsessionAttributes">设置共享值</a>
    <br/><br/><hr/>
    <a href="annoController2/getsessionAttributes">获取共享值</a>
    <br/><br/><hr/>
    <a href="annoController2/delsessionAttributes">清理共享值</a>


</body>
</html>
