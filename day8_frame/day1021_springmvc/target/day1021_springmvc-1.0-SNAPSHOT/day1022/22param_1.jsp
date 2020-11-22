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
    <title>参数绑定</title>
</head>
<body>
    <%--基本数据类型封装--%>
    <h4>基本数据类型绑定</h4>
    <a href="paramController/param?username=李白&password=2222">SpringMVC参数绑定</a>

    <br/><br/>
    <hr/>
    <%--引用类型封装数据--%>
    <h4>引用数据类型绑定，当请求为get请求时，不会出现中文乱码，当为post请求时，需要在web.xml文件中配置过滤器，处理中文乱码</h4>
    <form action="paramController/getReferenceType" method="post">
        名称：<input type="text" name="name"><br/>
        编号：<input type="text" name="id"><br/>
        金额：<input type="text" name="balance"><br/>
        姓名：<input type="text" name="user.name"><br/>
        年龄：<input type="text" name="user.age"><br/>
        <input type="submit" value="提交"/>
    </form>

    <br/><br/>
    <hr/>
    <%--绑定复杂数据类型，list和map集合--%>
    <h4>绑定复杂数据类型，list和map集合</h4>
    <form action="paramController/getCollection" method="post">
        名称：<input type="text" name="name"><br/>
        编号：<input type="text" name="id"><br/>
        金额：<input type="text" name="balance"><br/>
        姓名1：<input type="text" name="list[0].name"><br/>
        年龄1：<input type="text" name="list[0].age"><br/>
        姓名2：<input type="text" name="list[1].name"><br/>
        年龄2：<input type="text" name="list[1].age"><br/>
        姓名3：<input type="text" name="map['one'].name"><br/>
        年龄3：<input type="text" name="map['one'].age"><br/>
        姓名4：<input type="text" name="map['two'].name"><br/>
        年龄4：<input type="text" name="map['two'].age"><br/>
        <input type="submit" value="提交"/>
    </form>
    <br/><br/>
    <hr/>
    <%--转换器--%>
    <form action="paramController/stringToDate" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br/>
        生日:<input type="text" name="date"><br/>
        <input type="submit" value="提交"/>
    </form>

    <%--获取原生ServletAPI--%>
    <h4>获取原生ServletAPI</h4>
    <br/><br/>
    <hr>
    <a href="paramController/getServletAPI">获取原生ServletAPI</a>
</body>
</html>
