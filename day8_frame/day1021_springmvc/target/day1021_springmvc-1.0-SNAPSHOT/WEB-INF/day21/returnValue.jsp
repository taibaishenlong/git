<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2020/10/21
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>获取域对象中的值</title>
</head>
<body>
    <%--返回值类型为String类型--%>
    <h3>取得的值</h3>
    ${user.username}<br>
    ${user.age}<br>
    ${user.password}<br>

    <%--返回值类型为ModelAndView--%>
    <c:forEach items="${users}" var="user">
        ${user.username}
    </c:forEach>

</body>
</html>
