<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>登入页面</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/login.css" type="text/css">
    <script type="text/javascript" src="<%=basePath%>static/js/login.js"></script>
</head>
<body marginwidth="0" marginheight="0">
<div class="login">
	<%-- <div class="user-login">${message }</div> --%>
    <div class="login-box">
        <form action="<%=basePath%>/user/userLogin" method="post" id="form_login" onsubmit="return user_login()" style="margin-left: 38px">
            <div class="user-login" >密码登入
            	 <div id="username_error" style="color: red;font-size: 15px">${message }</div>
            </div>
			
            <!--//用户-->
            <div class="userName-login">
                <input type="text" class="login-userName-input" name="userName" id="userName"  placeholder="请输入用户名">
                <div id="username_error" ></div>
                <div id="username2_error" style="color: red; font-size: 16px ;text-align: center"></div>
            </div>
            <!--//m密码-->
            <div class="userName-login">
                <input type="password" class="login-userName-input" name="password" id="password" placeholder="请输入密码">
                <div id="password_error"></div>
            </div>
            <!-- //登入,注册按钮-->
            <div class="login-button">
                <input type="submit" value="登入" class="login-button-input" id="userLogin" name="login" >
                <input type="button" value="注册" class="login-button-input2" onclick="user_register()">
            </div>
        </form>
    </div>
</div>
</body>
</html>