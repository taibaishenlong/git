<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>返回值类型</title>
    <script src="../js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function() {
            $("#btn").click(function () {
                alert("进入绑定事件");
                //发送ajax请求
                $.ajax({
                   //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"李白","password":"222","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });

            $("#btn_jsonToJavaBean").click(function () {
                $.ajax({
                    url:"user/testJsonTojavaBean",
                    contentType: "application/json;charset=utf-8",
                    data:'{"username":"徐冬冬","password":"6666","age":39}',
                    dataType: "json",
                    type: "post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                    }
                });
            });

            $("#bt_javaBeanToJson").click(function () {
                //发送ajax请求
                $.ajax({
                    //编写json串
                    url:"user/testJavaBeanToJson",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"玛利亚","password":"8888","age":80}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <%--返回String类型--%>
    <a href="user/returnString">返回值类型为String类型</a>
    <br/>
    <%--返回值是void--%>
    <a href="user/returnVoid">返回值类型为void类型</a>
    <br/>
    <%--返回值类型是ModelAndView--%>
    <a href="user/returnModelAndView">返回值类型为ModelAndView</a>
    <br/>
    <%--spring框架提供的请求转发关键字forward--%>
    <a href="user/forward">spring框架提供的请求转发关键字forward</a>
    <br/>
    <%--spring框架提供的重定向关键字redirect--%>
    <a href="user/redirect">spring框架提供的重定向关键字redirect</a>

    <br/>
    <%--使用@RequestBody获取请求体数据--%>
    <button id="btn">发送ajax请求</button>
    <br>
    <%--使用@RequestBody注解把json字符串转换成javaBean对象--%>
    <button id="btn_jsonToJavaBean">把json转换成javaBean对象</button>
    <br/>
    <%--使用@RequestBody注解将javabean对象转换成json对象--%>
    <button id="bt_javaBeanToJson">将javaBean对象转换成json对象</button>
</body>
</html>
