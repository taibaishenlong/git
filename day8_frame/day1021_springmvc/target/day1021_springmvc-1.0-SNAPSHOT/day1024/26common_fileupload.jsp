<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h4>文件上传</h4>
    <form action="user/common_fileUpload" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br/>
        <input type="submit" value="普通io流上传文件">
    </form>
    <br/><br/>
    <form action="user/sprinvmvc_fileUpload" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br/>
        <input type="submit" value="springmvc上传文件">
    </form>

    <%--springmvc跨服务器上传文件--%>
    <h3>springmvc跨服务器上传文件</h3>
    <form action="user/fileupload_twoServer" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br/>
        <input type="submit" value="上传文件">
    </form>
</body>
</html>
