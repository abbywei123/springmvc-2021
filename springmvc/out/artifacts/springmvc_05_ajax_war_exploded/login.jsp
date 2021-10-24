<%--
  Created by IntelliJ IDEA.
  User: yw
  Date: 2021/10/20
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        function a1(){
            $.post("${pageContext.request.contextPath}/a3",{"name":$("#name").val()},function (data){
                if (data.toString()==='ok'){
                    $("#userInfo").css("color","green")
                }else{
                    $("#userInfo").css("color","red")
                }
                $("#userInfo").html(data)
            })
        }

        function a2(){
            $.post("${pageContext.request.contextPath}/a3",{"pwd":$("#pwd").val()},function (data){
                if (data.toString()==='ok'){
                    $("#pewdInfo").css("color","green")
                }else{
                    $("#pewdInfo").css("color","red")
                }
                $("#pewdInfo").html(data)
            })
        }
    </script>

</head>
<body>
<p>
    用户名： <input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码： <input type="text" id="pwd" onblur="a2()">
    <span id="pewdInfo"></span>
</p>
</body>
</html>
