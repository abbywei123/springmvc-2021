<%--
  Created by IntelliJ IDEA.
  User: yw
  Date: 2021/10/21
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <input type="text" name="username"/>
        <input type="text" name="password"/>
        <input type="submit" value="提交">
    </form>
</head>
<body>

</body>
</html>
